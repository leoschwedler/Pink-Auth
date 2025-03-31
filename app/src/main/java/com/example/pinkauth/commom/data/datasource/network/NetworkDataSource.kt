package com.example.pinkauth.commom.data.datasource.network

import com.example.pinkauth.commom.data.network.model.SigninRequest
import com.example.pinkauth.commom.data.network.model.SignupRequest
import com.example.pinkauth.commom.data.network.model.TokenResponse

interface NetworkDataSource {

    suspend fun signup(signupRequest: SignupRequest)

    suspend fun signin(signinRequest: SigninRequest): TokenResponse
}