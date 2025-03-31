package com.example.pinkauth.commom.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SigninRequest(
    val password: String,
    val username: String
)
