package com.example.pinkauth.features.signup.presentation.event

sealed class SignUpEvent {
    data object navigateToSignIn : SignUpEvent()
    data object navigateToHome : SignUpEvent()
    data class showSnackbar(val message: String) : SignUpEvent()
}