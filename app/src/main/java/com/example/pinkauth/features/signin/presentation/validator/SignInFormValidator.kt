package com.example.pinkauth.features.signin.presentation.validator

import com.example.pinkauth.commom.validator.EmailValidator
import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.commom.validator.PasswordValidator
import com.example.pinkauth.features.signin.presentation.state.SignInState
import javax.inject.Inject

class SignInFormValidator @Inject constructor(): FormValidator<SignInState> {
    override fun valid(value: SignInState): SignInState {
        val isEmailValid = EmailValidator.isValid(value.email)
        val isPasswordValid = PasswordValidator.isValid(value.password)

        val hasError = listOf(
            isEmailValid,

            isPasswordValid,

            ).any() { !it }

        return value.copy(
            isEmailError = !isEmailValid,
            isEmailErrorMessage = if (!isEmailValid) "email is not valid" else null,
            isPasswordError = !isPasswordValid,
            isPasswordErrorMessage = if (!isPasswordValid) "password is not valid" else null,
            hasError = hasError
        )
    }
}