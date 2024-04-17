package com.example.learntogether

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class LearnLayOut {

    @Composable
    fun CreateApp() {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)
            ) {
                Create("Title One", "Body One", Color.Yellow, Modifier.weight(1f))
                Create("Tilt Two", "Body Two", Color.LightGray,  Modifier.weight(1f))
            }

            Row(Modifier.weight(1f)) {
                Create(
                    "Second Row",
                    "Body seconddfad",
                    Color.Red,
                    Modifier.weight(1f)
                )
                Create(
                    "Second Row Two",
                    "Body Two seconddfdfddfdfdfdfdfdfdfdfd",
                    Color.Green,
                    Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun Create(title: String, body: String, backgroundColor: Color, modifier: Modifier = Modifier) {
        Column(
            modifier
                .fillMaxSize()
                .background(color = backgroundColor)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = body,
                textAlign = TextAlign.Justify,
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CreatePreview(modifier: Modifier = Modifier) {

        LearnTogetherTheme {
            CreateApp()
        }
    }
}