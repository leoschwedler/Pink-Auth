package com.example.pinkauth.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pinkauth.MainActivity
import com.example.pinkauth.features.signin.presentation.ui.SignInScreen
import com.example.pinkauth.features.signup.presentation.ui.SignUpScreen
import com.example.pinkauth.features.splash.presentation.ui.SplashScreen
import com.example.pinkauth.features.welcome.presentation.ui.WelcomeScreen
import com.example.pinkauth.navigation.routes.AuthRoute
import com.example.pinkauth.navigation.routes.AuthRoute.*
import com.example.pinkauth.navigation.routes.MainNavRoute

@Composable
fun AuthNavHost() {
    val navController = rememberNavController()
    val activity = navController.context as MainActivity
    NavHost(navController = navController, startDestination = SplashRoute) {

        composable<SplashRoute> {
            SplashScreen(
                navigateToSignUp = {
                    navController.navigate(SignUpRoute)
                },
                navigateToHome = {
                    navController.navigate(MainNavRoute.MainHomeRoute)
                },
                onClosesApp = {
                    activity.finish()
                }
            )
        }
        composable<WelcomeRoute> {
            WelcomeScreen(
                navigateToSignUp = {
                    navController.navigate(SignInRoute)
                }
            )
        }
        composable<SignUpRoute> {
            SignUpScreen(
                navigateToSignIn = {
                    navController.navigate(SignInRoute)
                },
                navigateToHome = {
                    navController.navigate(SignInRoute)
                })
        }
        composable<SignInRoute> {
            SignInScreen(
                navigateToSignUp = {
                    navController.navigate(SignUpRoute)
                },
                navigateToHome = {
                    navController.navigate(MainNavRoute.MainHomeRoute)
                }
            )
        }
        toMainNavHost(navController = navController)
    }
}
