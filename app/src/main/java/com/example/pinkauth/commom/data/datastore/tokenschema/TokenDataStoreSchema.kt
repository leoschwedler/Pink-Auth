package com.example.pinkauth.commom.data.datastore.tokenschema

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.tokenDataStore by preferencesDataStore(name = "token")

object TokenKeys {
    val ACCESS_TOKEN = stringPreferencesKey("access_token")
}