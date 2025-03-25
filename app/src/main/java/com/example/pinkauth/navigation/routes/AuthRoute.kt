package com.example.pinkauth.navigation.routes

import kotlinx.serialization.Serializable

sealed class AuthRoute {

    @Serializable
    data object SignInRoute: AuthRoute()
    @Serializable
    data object SignUpRoute: AuthRoute()
    @Serializable
    data object WelcomeRoute: AuthRoute()
}