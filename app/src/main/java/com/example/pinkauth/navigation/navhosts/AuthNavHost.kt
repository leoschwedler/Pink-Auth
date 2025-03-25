package com.example.pinkauth.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pinkauth.features.signin.presentation.ui.SignInScreen
import com.example.pinkauth.features.signup.presentation.ui.SignUpScreen
import com.example.pinkauth.features.welcome.presentation.ui.WelcomeScreen
import com.example.pinkauth.navigation.routes.AuthRoute

@Composable
fun AuthNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AuthRoute.WelcomeRoute) {
        composable<AuthRoute.WelcomeRoute> {
            WelcomeScreen()
        }
        composable<AuthRoute.SignUpRoute> {
            SignUpScreen()
        }
        composable<AuthRoute.SignInRoute> {
            SignInScreen()
        }
    }
}
