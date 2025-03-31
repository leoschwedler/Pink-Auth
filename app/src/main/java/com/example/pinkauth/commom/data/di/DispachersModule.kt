package com.example.pinkauth.commom.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DispachersModule {

    @IoDispatcher
    @Provides
    fun providesIoDispacher(): CoroutineDispatcher{
        return Dispatchers.IO
    }

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispacher(): CoroutineDispatcher{
        return Dispatchers.Default
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher