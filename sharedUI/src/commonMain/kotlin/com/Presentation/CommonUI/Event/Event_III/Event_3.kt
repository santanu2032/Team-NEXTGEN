package com.Presentation.CommonUI.Event.Event_III


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.localdatabase.TraderDao


@Composable
fun Event_3(traderDao_: TraderDao) {
    var showNewRegisterUI by remember { mutableStateOf(false) }
    var showRegisterUI: Boolean by remember{mutableStateOf(false)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box(modifier = Modifier

            .fillMaxWidth(0.4f)
            .fillMaxHeight(0.2f)
            .background(color = Color.White)
            .align(BiasAlignment(horizontalBias = 0f, verticalBias = 0f))
            .clickable{
                showNewRegisterUI=true

            }, contentAlignment = Alignment.Center
        ){
            Text("New Register")
        }
        Box(modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(0.4f)
            .background(color = Color.White)
            .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.8f))
            .clickable{
                println("Register Account clicked")
                showRegisterUI=true
            }
            , contentAlignment = Alignment.Center
        ){
            Text("Register Account")
        }
        if(showRegisterUI){
            RegisteredUsersScreen(traderDao_)
        }
        else{}
        Text("DEBUG showRegisterUI = $showRegisterUI", color = Color.Red)
        if (showNewRegisterUI){
            New_Register_UI()
        }
        else{}


    }
}