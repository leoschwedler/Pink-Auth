package com.example.pinkauth.features.signup.presentation.validator

import com.example.pinkauth.commom.validator.EmailValidator
import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.commom.validator.PasswordValidator
import com.example.pinkauth.commom.validator.PhoneNumberValidator
import com.example.pinkauth.features.signup.presentation.state.SignUpState
import javax.inject.Inject

class SignUpFormValidator @Inject constructor() : FormValidator<SignUpState> {
    override fun valid(value: SignUpState): SignUpState {
        val isEmailValid = EmailValidator.isValid(value.email)
        val isPhoneNumberValid = PhoneNumberValidator.isValid(value.phoneNumber)
        val isPasswordValid = PasswordValidator.isValid(value.password)
        val isConfirmPasswordValid =
            PasswordValidator.isValid(value.confirmPassword) && value.password == value.confirmPassword


        val hasError = listOf(
            isEmailValid,
            isPhoneNumberValid,
            isPasswordValid,
            isConfirmPasswordValid
        ).any() { !it }

        return value.copy(
            isEmailError = !isEmailValid,
            isEmailErrorMessage = if (!isEmailValid) "email is not valid" else null,
            isPhoneNumberError = !isPhoneNumberValid,
            isPhoneNumberErrorMessage = if (!isPhoneNumberValid) "phone number is not valid" else null,
            isPasswordError = !isPasswordValid,
            isPasswordErrorMessage = if (!isPasswordValid) "password is not valid" else null,
            isConfirmPasswordError = !isConfirmPasswordValid,
            isConfirmPasswordErrorMessage = if (!isConfirmPasswordValid) "confirm password is not valid" else null,
            hasError = hasError
        )
    }
}