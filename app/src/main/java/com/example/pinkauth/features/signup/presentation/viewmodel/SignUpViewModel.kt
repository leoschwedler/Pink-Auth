package com.example.pinkauth.features.signup.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinkauth.commom.data.network.model.NetworkException
import com.example.pinkauth.commom.data.repository.AuthRepository
import com.example.pinkauth.commom.domain.SignupDomain
import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.features.signup.presentation.action.SignUpAction
import com.example.pinkauth.features.signup.presentation.event.SignUpEvent
import com.example.pinkauth.features.signup.presentation.state.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val formValidator: FormValidator<SignUpState>,
    private val authRepository: AuthRepository
) :
    ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<SignUpEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.onEmailChange -> {
                _uiState.update { it.copy(email = action.email) }
            }

            is SignUpAction.onPhoneNumberChange -> {
                _uiState.update { it.copy(phoneNumber = action.phoneNumber) }
            }

            is SignUpAction.onPasswordChange -> {
                _uiState.update { it.copy(password = action.password) }
            }

            is SignUpAction.onConfirmPasswordChange -> {
                _uiState.update { it.copy(confirmPassword = action.confirmPassword) }
            }

            SignUpAction.navigateToSignIn -> {
                viewModelScope.launch {
                    _uiEvent.send(SignUpEvent.navigateToSignIn)
                }
            }

            SignUpAction.onSubmit -> {
                onSubmit()
            }
        }
    }

    fun onSubmit() {
        if (isValidForm()) {
            viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true) }
                val request = SignupDomain(
                    firstName = "Leo",
                    lastName = "Schwedler",
                    password = _uiState.value.password,
                    profilePictureId = null,
                    username = _uiState.value.email
                )
                val result = authRepository.signup(request).fold(
                    onSuccess = {
                        _uiState.update { it.copy(isLoading = false) }
                        _uiEvent.send(SignUpEvent.showSnackbar(message = "✅ Your account has been successfully created!"))
                        _uiEvent.send(SignUpEvent.navigateToHome)
                    },
                    onFailure = {
                        if (it is NetworkException.ApiException) {
                            when (it.statusCode) {
                                400 -> {
                                    _uiState.update { it.copy(isLoading = false) }
                                    _uiEvent.send(SignUpEvent.showSnackbar(message = "❌ Invalid email or password"))
                                }

                                409 -> {
                                    _uiState.update { it.copy(isLoading = false) }
                                    _uiEvent.send(SignUpEvent.showSnackbar(message = "❌ User already exists"))
                                }

                                else -> {
                                    _uiState.update { it.copy(isLoading = false) }
                                    _uiEvent.send(SignUpEvent.showSnackbar(message = "❌ Something went wrong"))
                                }

                            }
                        } else {
                            _uiState.update { it.copy(isLoading = false) }
                            _uiEvent.send(SignUpEvent.showSnackbar(message = "❌ Something went wrong Unknown error"))
                        }
                    }
                )
            }
        }
    }

    fun isValidForm(): Boolean {
        val validateState = formValidator.valid(_uiState.value)
        _uiState.update { validateState }
        return !validateState.hasError
    }

}