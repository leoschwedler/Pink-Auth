package com.example.pinkauth.commom.domain

data class SignupDomain(
    val firstName: String,
    val lastName: String,
    val password: String,
    val profilePictureId: String? = null,
    val username: String
)
