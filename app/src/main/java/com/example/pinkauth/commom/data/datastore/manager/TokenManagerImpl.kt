package com.example.pinkauth.commom.data.datastore.manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.pinkauth.commom.data.datastore.tokenschema.TokenKeys
import com.example.pinkauth.commom.data.datastore.tokenschema.tokenDataStore
import com.example.pinkauth.commom.data.di.IoDispatcher
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenManagerImpl
@Inject constructor(
    @ApplicationContext private val context: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : TokenManager {

    private val tokenDataStore = context.tokenDataStore

    override val accessToken: Flow<String>
        get() = tokenDataStore.data.map { preferences ->
            preferences[TokenKeys.ACCESS_TOKEN] ?: ""
        }

    override suspend fun saveAccessToken(token: String) {
        withContext(ioDispatcher){
            tokenDataStore.edit { preferences ->
                preferences[TokenKeys.ACCESS_TOKEN] = token
            }
        }
    }

    override suspend fun clearAccessToken() {
        withContext(ioDispatcher){
            tokenDataStore.edit { preferences ->
                preferences.remove(TokenKeys.ACCESS_TOKEN)
            }
        }
    }
}