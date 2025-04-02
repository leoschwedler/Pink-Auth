package com.example.pinkauth.features.splash.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinkauth.commom.data.repository.AuthRepository
import com.example.pinkauth.features.splash.presentation.event.SplashEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _uiEvent = Channel<SplashEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _showAlertDialog = MutableStateFlow(false)
    val showAlertDialog = _showAlertDialog

    fun authenticate() {
        viewModelScope.launch {
            onDialogDismiss()

            val accessToken = authRepository.getAccessToken()
            if (accessToken.isNullOrBlank()) {
                _uiEvent.send(SplashEvent.showSnackbar(message = "Not authenticated"))
                delay(3000)
                _uiEvent.send(SplashEvent.Authentication.NotAuthenticated)
            } else {
                authRepository.authenticate(accessToken).fold(
                    onSuccess = {
                        _uiEvent.send(SplashEvent.showSnackbar(message = "Authenticated"))
                        delay(3000)
                        _uiEvent.send(SplashEvent.Authentication.Authenticated)
                    },
                    onFailure = {
                        _showAlertDialog.value = true
                    }
                )
            }
        }
    }

    fun onDialogDismiss() {
        _showAlertDialog.value = false
    }
}