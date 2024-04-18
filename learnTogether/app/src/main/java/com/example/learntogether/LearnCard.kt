package com.example.learntogether

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class LearnCard {
    @Composable
    fun CardsApp(){
        Row {
            Cards(
                firstText = "First Title",
                secondText = "First Body",
                modifier = Modifier.weight(1f),
                backgroundColor = Color.Blue
            )
            Cards(
                firstText = "Second Title  But I want size to be equal",
                secondText = "Second Body",
                modifier = Modifier.weight(1f),
                backgroundColor = Color.Cyan
            )
            Cards(
                firstText = "Second Title  But I want size to be equal",
                secondText = "Second Body",
                modifier = Modifier.weight(1f),
                backgroundColor = Color.Yellow
            )
        }
    }

    @Composable
    fun Cards(firstText: String, secondText: String, modifier: Modifier, backgroundColor: Color){
        Column(
            modifier
                .background(backgroundColor)
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = firstText,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(text = secondText)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CardPreview(modifier: Modifier = Modifier) {
        LearnTogetherTheme {
            CardsApp()
        }
    }
}