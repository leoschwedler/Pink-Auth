package com.example.pinkauth.features.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.features.signin.presentation.action.SignInAction
import com.example.pinkauth.features.signin.presentation.event.SignInEvent
import com.example.pinkauth.features.signin.presentation.state.SignInState
import com.example.pinkauth.features.signup.presentation.event.SignUpEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val formValidator: FormValidator<SignInState>) :
    ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<SignInEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: SignInAction) {
        when (action) {
            is SignInAction.onEmailChange -> {
                _uiState.update { it.copy(email = action.email) }
            }

            is SignInAction.onPasswordChange -> {
                _uiState.update { it.copy(password = action.password) }
            }

            SignInAction.onRadioButtonChange -> {
                _uiState.update { it.copy(radionButtonState = !it.radionButtonState) }
            }

            SignInAction.onSubmit -> {
                onSubmit()
            }

            SignInAction.navigateToSignUp -> {
                viewModelScope.launch {
                    _uiEvent.send(SignInEvent.navigateToSignUp)
                }
            }
        }
    }

    fun onSubmit() {
        if (isValidForm()) {
            viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true) }
                _uiEvent.send(SignInEvent.showSnackbar(message = "✅ Login successful. You can now access your account"))
                delay(1000)
                _uiEvent.send(SignInEvent.navigateToHome)
            }
        }
    }

    fun isValidForm(): Boolean {
        val validateForm = formValidator.valid(_uiState.value)
        _uiState.update { validateForm }
        return !validateForm.hasError
    }
}