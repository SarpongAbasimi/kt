package com.example.learntogether

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class ComposeQuadrant {
    companion object {
        val SCREEN_WIDTH =  @Composable {
            LocalConfiguration.current.screenWidthDp / 2
        }
    }

    @Composable
    fun CardOne(title: String, body: String, modifier: Modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
        ) {
            Text(
                text = title,
                modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, modifier, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun CardTwo(title: String, body: String, modifier: Modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(Color.Cyan)
                .fillMaxHeight(0.5f)
        ) {
            Text(
                text = title,
                modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, modifier, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun CardThree(title: String, body: String, modifier: Modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(Color.Cyan)
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
        ) {
            Text(
                text = title,
                modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, modifier, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun CardFour(title: String, body: String, modifier: Modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxHeight()
        ) {
            Text(
                text = title,
                modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, modifier, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun Page(
        titleOne: String,
        titleTwo: String,
        titleThree: String,
        titleFour: String,
        bodyOne: String,
        bodyTwo: String,
        bodyThree: String,
        bodyFour: String,
        modifier: Modifier
    ) {
        Column {
            Row(modifier = modifier) {
                CardOne(
                    titleOne,
                    bodyOne,
                    modifier = modifier
                )
                CardTwo(
                    titleTwo,
                    bodyTwo,
                    modifier = modifier
                )

            }
            Row(modifier = modifier) {
                CardThree(
                    titleThree,
                    bodyThree,
                    modifier = modifier
                )
                CardFour(
                    titleFour,
                    bodyFour,
                    modifier = modifier
                )

            }
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun CardPreview(modifier: Modifier = Modifier){
        LearnTogetherTheme {
            Page(
                "One",
                "Two",
                "Three",
                "Four",
                "Body One",
                "Body Two",
                "Body Three",
                "Body Four",
                modifier
            )
        }
    }
}