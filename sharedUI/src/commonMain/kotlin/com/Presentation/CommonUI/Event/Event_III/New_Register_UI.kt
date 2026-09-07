package com.Presentation.CommonUI.Event.Event_III

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun New_Register_UI() {
    var usernameState by remember { mutableStateOf("") }
    val userpassword by remember { mutableStateOf("") }
    Box(
        modifier = Modifier

            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.08f)
                .fillMaxWidth(0.73f)
                .background(Color.White)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.5f))
        ) {
            TextField(
                value = usernameState,
                onValueChange = { usernameState = it },
                placeholder = { Text("Enter Username") }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.08f)
                .fillMaxWidth(0.73f)
                .background(Color.White)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.2f))
        ) {
            TextField(
                value = userpassword,
                onValueChange = { usernameState = it },
                placeholder = { Text("Enter Password") }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.06f)
                .fillMaxWidth(0.2f)
                .background(Color.White)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = 0f)),
            contentAlignment = Alignment.Center
        ) {
            Text("Upload")
        }
    }
}