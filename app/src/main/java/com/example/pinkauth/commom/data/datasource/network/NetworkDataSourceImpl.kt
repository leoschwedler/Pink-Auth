package com.example.pinkauth.commom.data.datasource.network

import com.example.pinkauth.commom.data.network.model.AuthenticateResponse
import com.example.pinkauth.commom.data.network.model.SigninRequest
import com.example.pinkauth.commom.data.network.model.SignupRequest
import com.example.pinkauth.commom.data.network.model.TokenResponse

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val httpClient: HttpClient) : NetworkDataSource {
    override suspend fun signup(signupRequest: SignupRequest) {
        httpClient.post("signup") {
            setBody(signupRequest)
        }.body<Unit>()
    }

    override suspend fun signin(signinRequest: SigninRequest): TokenResponse {
        return httpClient.post("signin") {
            setBody(signinRequest)
        }.body()
    }

    override suspend fun authenticate(token: String): AuthenticateResponse {
       return httpClient.get("authenticate"){
            header(HttpHeaders.Authorization, "Bearer $token")
        }.body()
    }
}