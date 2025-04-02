package com.example.pinkauth.features.splash.presentation.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LifecycleStartEffect
import com.example.pinkauth.commom.theme.Pink
import com.example.pinkauth.features.splash.presentation.event.SplashEvent
import com.example.pinkauth.features.splash.presentation.viewmodel.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    onClosesApp: () -> Unit
) {
    val showAlertDialog by viewModel.showAlertDialog.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LifecycleStartEffect(Unit) {
        viewModel.authenticate()
        onStopOrDispose { }
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is SplashEvent.showSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }

                SplashEvent.Authentication.Authenticated -> {
                    navigateToHome()
                }

                SplashEvent.Authentication.NotAuthenticated -> {
                    navigateToSignUp()
                }
            }

        }
    }
    if (showAlertDialog) {
        AlertDialog(
            onDismissRequest = onClosesApp,
            title = {
                Text(text = "Error")
            },
            text = {
                Text(text = "Something went wrong")
            },
            confirmButton = {
                Button(onClick = onClosesApp) {
                    Text(text = "Close App")
                }
            }
        )
    }
    Box(Modifier.fillMaxSize()) {
        SplashContent()
        SnackbarHost(
            snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp),
            snackbar = { data ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                snackbarData = data,
                containerColor = Pink,
                contentColor = Color.White
            )
        })
    }


}

@Composable
private fun SplashContent() {
    Box(Modifier.fillMaxSize()) {
        Text(
            text = "SplashScreen",
            fontSize = 40.sp,
            color = Pink,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview
@Composable
private fun SplashPreview() {
    SplashScreen(
        navigateToHome = {},
        navigateToSignUp = {},
        onClosesApp = {}
    )
}