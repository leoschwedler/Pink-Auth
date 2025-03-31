package com.example.pinkauth.commom.data.repository

import com.example.pinkauth.commom.data.datasource.network.NetworkDataSource
import com.example.pinkauth.commom.data.di.IoDispatcher
import com.example.pinkauth.commom.data.network.model.SignupRequest
import com.example.pinkauth.commom.domain.SigninDomain
import com.example.pinkauth.commom.domain.SignupDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    @IoDispatcher private val ioDispacher: CoroutineDispatcher
) :
    AuthRepository {
    override suspend fun signup(signupDomain: SignupDomain): Result<Unit> {
      return  withContext(ioDispacher){
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
        TODO("Not yet implemented")
    }
}