package com.example.pinkauth.features.signin.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.pinkauth.R
import com.example.pinkauth.commom.components.PrimaryButton
import com.example.pinkauth.commom.components.PrimaryTextField
import com.example.pinkauth.commom.theme.Gray
import com.example.pinkauth.commom.theme.MainGray
import com.example.pinkauth.commom.theme.Pink

@Composable
fun SignInScreen() {
    SignInContent()
}

@Composable
private fun SignInContent() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.signin),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
        ) {
            Spacer(modifier = Modifier.height(370.dp))
            Text(
                text = "Sign In",
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
                value = "",
                onValueChange = {},
                placeholder = "Email",
                leadingIcon = Icons.Filled.Email,
                keyboardType = KeyboardType.Email,
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryTextField(
                value = "",
                onValueChange = {},
                placeholder = "Password",
                leadingIcon = Icons.Filled.Lock,
                keyboardType = KeyboardType.Password,
                imeAction = androidx.compose.ui.text.input.ImeAction.Done
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Pink,
                        unselectedColor = Color.Gray
                    ),
                    onClick = { }
                )
                Text(text = "Remember Me", fontWeight = FontWeight.Medium, fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Pink
                )
                Spacer(Modifier.height(80.dp))

            }
            PrimaryButton(title = "Login", onClick = {}, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Don't have an account?",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Gray
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Pink
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignInPreview() {
    SignInScreen()
}