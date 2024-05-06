package com.example.learntogether.ui.navigationui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScreenTwo(cardData: String, modifier: Modifier){
    Column(modifier) {
        CardScreen(cardData, Modifier.background(Color.Cyan))
        Spacer(modifier = Modifier.height(5.dp))
        CardScreen(cardData, Modifier.background(Color.LightGray))
    }
}


