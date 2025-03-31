package com.example.pinkauth.commom.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    val firstName: String,
    val lastName: String,
    val password: String,
    val profilePictureId: String? = null,
    val username: String
)
