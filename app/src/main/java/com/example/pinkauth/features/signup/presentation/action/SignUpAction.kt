package com.example.pinkauth.features.signup.presentation.action

sealed class SignUpAction {
    data class onEmailChange(val email: String): SignUpAction()
    data class onPhoneNumberChange(val phoneNumber: String): SignUpAction()
    data class onPasswordChange(val password: String): SignUpAction()
    data class onConfirmPasswordChange(val confirmPassword: String): SignUpAction()
    data object onSubmit: SignUpAction()
    data object navigateToSignIn: SignUpAction()
}