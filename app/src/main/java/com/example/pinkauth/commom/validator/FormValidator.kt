package com.example.pinkauth.commom.validator

interface FormValidator<T> {
    fun valid(value: T): T
}