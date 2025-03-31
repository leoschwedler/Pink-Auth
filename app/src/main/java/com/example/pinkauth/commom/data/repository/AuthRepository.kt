package com.example.pinkauth.commom.data.repository

import com.example.pinkauth.commom.domain.SigninDomain
import com.example.pinkauth.commom.domain.SignupDomain

interface AuthRepository {

    suspend fun signup(signupDomain: SignupDomain) : Result<Unit>

    suspend fun signin(signinDomain: SigninDomain) : Result<Unit>
}