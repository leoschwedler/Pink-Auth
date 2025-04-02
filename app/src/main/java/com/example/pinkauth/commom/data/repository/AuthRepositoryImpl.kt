package com.example.pinkauth.commom.data.repository

import com.example.pinkauth.commom.data.datasource.network.NetworkDataSource
import com.example.pinkauth.commom.data.datastore.manager.TokenManager
import com.example.pinkauth.commom.data.di.IoDispatcher
import com.example.pinkauth.commom.data.network.model.SigninRequest
import com.example.pinkauth.commom.data.network.model.SignupRequest
import com.example.pinkauth.commom.domain.SigninDomain
import com.example.pinkauth.commom.domain.SignupDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val tokenManager: TokenManager,
    @IoDispatcher private val ioDispacher: CoroutineDispatcher
) :
    AuthRepository {
    override suspend fun signup(signupDomain: SignupDomain): Result<Unit> {
        return withContext(ioDispacher) {
            runCatching {
                val request = SignupRequest(
                    firstName = signupDomain.firstName,
                    lastName = signupDomain.lastName,
                    password = signupDomain.password,
                    profilePictureId = signupDomain.profilePictureId,
                    username = signupDomain.username
                )
                networkDataSource.signup(request)
            }
        }
    }

    override suspend fun signin(signinDomain: SigninDomain): Result<Unit> {
        return withContext(ioDispacher) {
            runCatching {
                val request = SigninRequest(
                    username = signinDomain.username,
                    password = signinDomain.password
                )
                val tokenResponse = networkDataSource.signin(request)
                tokenManager.saveAccessToken(tokenResponse.token)
            }
        }
    }

    override suspend fun authenticate(token: String): Result<Unit> {
        return withContext(ioDispacher) {
            runCatching {
                val tokenResponse = networkDataSource.authenticate(token)
            }
        }
    }

    override suspend fun clearAccessToken() {
        withContext(ioDispacher) {
            tokenManager.clearAccessToken()
        }
    }

    override suspend fun getAccessToken(): String? {
        return withContext(ioDispacher) {
            tokenManager.accessToken.firstOrNull()
        }
    }
}