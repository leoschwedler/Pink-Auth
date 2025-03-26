package com.example.pinkauth.commom.validator

object PhoneNumberValidator {
    private const val PHONE_NUMBER_REGEX = "^\\(?\\d{2}\\)?\\s?(?:9\\d{4}-?\\d{4})\$"

    fun isValid(value: String): Boolean {
        return PHONE_NUMBER_REGEX.toRegex().matches(value)
    }
}