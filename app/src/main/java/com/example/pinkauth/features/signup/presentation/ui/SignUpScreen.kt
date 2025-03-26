package com.example.pinkauth.features.signup.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material3.Divider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pinkauth.R
import com.example.pinkauth.commom.components.PrimaryButton
import com.example.pinkauth.commom.components.PrimaryTextField
import com.example.pinkauth.commom.theme.Gray
import com.example.pinkauth.commom.theme.MainGray
import com.example.pinkauth.commom.theme.Pink
import com.example.pinkauth.features.signup.presentation.action.SignUpAction
import com.example.pinkauth.features.signup.presentation.event.SignUpEvent
import com.example.pinkauth.features.signup.presentation.state.SignUpState
import com.example.pinkauth.features.signup.presentation.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    viewmodel: SignUpViewModel = hiltViewModel(),
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit
) {
    val uiState by viewmodel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewmodel.uiEvent.collect { event ->
            when (event) {
                SignUpEvent.navigateToHome -> {
                    navigateToHome()
                }

                SignUpEvent.navigateToSignIn -> {
                    navigateToSignIn()
                }

                is SignUpEvent.showSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        SignUpContent(
            uiState = uiState,
            onAction = viewmodel::onAction
        )
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
private fun SignUpContent(
    uiState: SignUpState,
    onAction: (SignUpAction) -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.signup),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(250.dp))
            Text(
                text = "Sign Up",
                color = MainGray,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                Modifier
                    .width(75.dp)
                    .height(3.dp), color = Pink
            )
            Spacer(modifier = Modifier.height(40.dp))
            PrimaryTextField(
                value = uiState.email,
                onValueChange = {
                    onAction(SignUpAction.onEmailChange(it))
                },
                isError = uiState.isEmailError,
                isErrorMessage = uiState.isEmailErrorMessage,
                placeholder = "Email",
                leadingIcon = Icons.Filled.Email,
                keyboardType = KeyboardType.Email,
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryTextField(
                value = uiState.phoneNumber,
                onValueChange = {
                    onAction(SignUpAction.onPhoneNumberChange(it))
                },
                isError = uiState.isPhoneNumberError,
                isErrorMessage = uiState.isPasswordErrorMessage,
                placeholder = "+00 000-000-0000",
                leadingIcon = Icons.Filled.PhoneIphone,
                keyboardType = KeyboardType.Number,
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryTextField(
                value = uiState.password,
                onValueChange = {
                    onAction(SignUpAction.onPasswordChange(it))
                },
                isError = uiState.isPasswordError,
                isErrorMessage = uiState.isPasswordErrorMessage,
                placeholder = "Enter your password",
                leadingIcon = Icons.Filled.Lock,
                keyboardType = KeyboardType.Password,
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryTextField(
                value = uiState.confirmPassword,
                onValueChange = {
                    onAction(SignUpAction.onConfirmPasswordChange(it))
                },
                isError = uiState.isConfirmPasswordError,
                isErrorMessage = uiState.isConfirmPasswordErrorMessage,
                placeholder = "Enter Confirm your password",
                leadingIcon = Icons.Filled.Lock,
                keyboardType = KeyboardType.Password,
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            )
            Spacer(modifier = Modifier.height(50.dp))
            PrimaryButton(
                title = "Create Account",
                onClick = {
                    onAction(SignUpAction.onSubmit)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Already have an Account!",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Gray,

                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "Login",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Pink,
                    modifier = Modifier.clickable {
                        onAction(SignUpAction.navigateToSignIn)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignUpPreview() {
    SignUpScreen(
        navigateToSignIn = {},
        navigateToHome = {}
    )
}