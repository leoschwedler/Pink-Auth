package com.example.pinkauth.commom.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticateResponse (
    val firstName: String,
    val id: Int,
    val lastName: String,
    val profilePictureUrl: String?,
    val username: String
)