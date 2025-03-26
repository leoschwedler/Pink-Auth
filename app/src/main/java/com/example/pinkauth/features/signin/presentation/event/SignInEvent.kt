package com.example.pinkauth.features.signin.presentation.event

sealed class SignInEvent {
    data object navigateToHome : SignInEvent()
    data object navigateToSignUp : SignInEvent()
    data class showSnackbar(val message: String) : SignInEvent()
}