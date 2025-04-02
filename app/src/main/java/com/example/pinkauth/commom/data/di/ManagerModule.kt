package com.example.pinkauth.commom.data.di

import com.example.pinkauth.commom.data.datastore.manager.TokenManager
import com.example.pinkauth.commom.data.datastore.manager.TokenManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    @Singleton
    fun bindTokenManager(tokenManagerImpl: TokenManagerImpl) : TokenManager
}