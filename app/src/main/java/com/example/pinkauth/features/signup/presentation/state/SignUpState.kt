package com.example.pinkauth.features.signup.presentation.state

data class SignUpState(
    val email: String = "",
    val isEmailError: Boolean = false,
    val isEmailErrorMessage: String? = null,
    val phoneNumber: String = "",
    val isPhoneNumberError: Boolean = false,
    val isPhoneNumberErrorMessage: String? = null,
    val password: String = "",
    val isPasswordError: Boolean = false,
    val isPasswordErrorMessage: String? = null,
    val confirmPassword: String = "",
    val isConfirmPasswordError: Boolean = false,
    val isConfirmPasswordErrorMessage: String? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
)
