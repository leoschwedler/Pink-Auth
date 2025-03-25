package com.example.pinkauth.commom.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.pinkauth.R
import com.example.pinkauth.commom.theme.Pink

@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector,
    isError: Boolean = false,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    modifier: Modifier = Modifier
) {
    var isVisiblePassword by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        singleLine = true,
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(

            unfocusedBorderColor = Color.Gray,
            errorBorderColor = Color.Red,
            focusedBorderColor = Pink,
            focusedTrailingIconColor = Color(0xFF626262),
            unfocusedTrailingIconColor = Color(0xFF626262),),
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        visualTransformation = if (keyboardType == KeyboardType.Password) {
            if (isVisiblePassword) {
                VisualTransformation.None
            } else {

                PasswordVisualTransformation()
            }
        } else {
            VisualTransformation.None
        },
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        shape = MaterialTheme.shapes.small,
        trailingIcon = {
            if (keyboardType == KeyboardType.Password && value.isNotBlank()) {
                val icon = if (isVisiblePassword) {
                    R.drawable.ic_visibility_off
                } else {
                    R.drawable.ic_visibility
                }

                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isVisiblePassword = !isVisiblePassword
                    })
            }
        },
        placeholder = { Text(text = placeholder) },
    )
}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {

    PrimaryTextField(
        value = "",
        onValueChange = {},
        placeholder = "Email",
        leadingIcon = Icons.Filled.Email,
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Next

    )

}