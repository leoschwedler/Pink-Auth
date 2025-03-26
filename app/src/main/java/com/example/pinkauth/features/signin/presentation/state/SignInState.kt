package com.example.pinkauth.features.signin.presentation.state

data class SignInState(
    val email: String = "",
    val isEmailError: Boolean = false,
    val isEmailErrorMessage: String? = null,
    val password: String = "",
    val isPasswordError: Boolean = false,
    val isPasswordErrorMessage: String? = null,
    val radionButtonState: Boolean = false,
    val isLoading: Boolean = false,
    val hasError: Boolean = false
)
