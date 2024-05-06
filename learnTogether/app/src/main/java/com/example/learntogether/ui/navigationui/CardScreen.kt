package com.example.learntogether.ui.navigationui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CardScreen(cardData: String, modifier: Modifier){
    Text(text = cardData, modifier, textAlign = TextAlign.Center)
}