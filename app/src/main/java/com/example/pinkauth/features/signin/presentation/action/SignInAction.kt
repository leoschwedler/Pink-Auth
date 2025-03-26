package com.example.pinkauth.features.signin.presentation.action

sealed class SignInAction {
    data class onEmailChange(val email: String) : SignInAction()
    data class onPasswordChange(val password: String) : SignInAction()
    data object onRadioButtonChange : SignInAction()
    data object navigateToSignUp : SignInAction()
    data object onSubmit : SignInAction()
}