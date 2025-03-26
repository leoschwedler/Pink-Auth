package com.example.pinkauth.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pinkauth.features.signin.presentation.ui.SignInScreen
import com.example.pinkauth.features.signup.presentation.ui.SignUpScreen
import com.example.pinkauth.features.welcome.presentation.ui.WelcomeScreen
import com.example.pinkauth.navigation.routes.AuthRoute
import com.example.pinkauth.navigation.routes.MainNavRoute

@Composable
fun AuthNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AuthRoute.WelcomeRoute) {
        composable<AuthRoute.WelcomeRoute> {
            WelcomeScreen(
                navigateToSignUp = {
                    navController.navigate(AuthRoute.SignInRoute)
                }
            )
        }
        composable<AuthRoute.SignUpRoute> {
            SignUpScreen(
                navigateToSignIn = {
                    navController.navigate(AuthRoute.SignInRoute)
                },
                navigateToHome = {
                    navController.navigate(AuthRoute.SignInRoute)
                })
        }
        composable<AuthRoute.SignInRoute> {
            SignInScreen(
                navigateToSignUp = {
                    navController.navigate(AuthRoute.SignUpRoute)
                },
                navigateToHome = {
                    navController.navigate(MainNavRoute.MainHomeRoute)
                }
            )
        }
        toMainNavHost(navController = navController)
    }
}
