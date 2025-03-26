package com.example.pinkauth.features.home.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pinkauth.commom.theme.Pink

@Composable
fun HomeScreen() {
 HomeContent()
}

@Composable
private fun HomeContent() {
    Box(Modifier.fillMaxSize()){
        Text(text = "Home", fontSize = 40.sp, color = Pink, modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
private fun HomePreview() {
 HomeScreen()
}