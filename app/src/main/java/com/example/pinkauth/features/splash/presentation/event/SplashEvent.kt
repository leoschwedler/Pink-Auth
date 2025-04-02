package com.example.pinkauth.features.splash.presentation.event

sealed class SplashEvent {
    data class showSnackbar(val message: String) : SplashEvent()
    interface Authentication {
        data object Authenticated : SplashEvent()
        data object NotAuthenticated : SplashEvent()
    }
}