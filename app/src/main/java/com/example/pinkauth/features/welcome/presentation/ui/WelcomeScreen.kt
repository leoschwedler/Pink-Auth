package com.example.pinkauth.features.welcome.presentation.ui

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pinkauth.R
import com.example.pinkauth.commom.theme.Gray
import com.example.pinkauth.commom.theme.MainGray

@Composable
fun WelcomeScreen(navigateToSignUp: () -> Unit) {
    WelcomeContent(
        navigateToSignUp = navigateToSignUp
    )
}

@Composable
private fun WelcomeContent(
    navigateToSignUp: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.welcome),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(400.dp))
            Text(
                text = "Welcome",
                color = MainGray,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Lorem ipsum dolor sit amet consectetur.\nLorem id sit",
                color = Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 24.dp, bottom = 60.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Continue",
                    color = Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { navigateToSignUp() })
            }
        }
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    WelcomeScreen(
        {}
    )
}