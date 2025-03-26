package com.example.pinkauth.navigation.routes

import kotlinx.serialization.Serializable

sealed class MainNavRoute {

    @Serializable
    data object MainGraphRoute : MainNavRoute()

    @Serializable
    data object  MainHomeRoute : MainNavRoute()
}