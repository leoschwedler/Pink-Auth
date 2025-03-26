package com.example.pinkauth.navigation.navhosts

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pinkauth.features.home.presentation.ui.HomeScreen
import com.example.pinkauth.navigation.routes.MainNavRoute
import com.example.pinkauth.navigation.routes.MainNavRoute.*

fun NavGraphBuilder.toMainNavHost(navController: NavController) {
    navigation<MainGraphRoute> (
        startDestination = MainHomeRoute
    ){
        composable<MainHomeRoute> {
            HomeScreen()
        }
    }
}