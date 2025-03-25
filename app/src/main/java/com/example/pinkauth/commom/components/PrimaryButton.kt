package com.example.pinkauth.commom.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pinkauth.commom.theme.Pink

@Composable
fun PrimaryButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.height(60.dp),
        onClick = onClick,

        colors = ButtonDefaults.buttonColors(
            containerColor = Pink
        )
    ) {
        Text(title, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {

    PrimaryButton(
        title = "Cadastrar",
        onClick = {}
    )
}