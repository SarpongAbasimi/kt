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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class ComposeQuadrant {

    @Composable
    fun CardInfo(title: String, body: String, backgroundColor: Color, modifier: Modifier = Modifier){
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                modifier.padding(bottom = 1.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun CardInfoQuadrant(modifier: Modifier){
        Column(modifier.fillMaxWidth()) {
            Row(modifier.weight(1f)) {
                CardInfo(
                    title = stringResource(id = R.string.title_one),
                    body = stringResource(id = R.string.body_one),
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = modifier.weight(1f)
                )
                CardInfo(
                    title = stringResource(id = R.string.title_two), 
                    body = stringResource(id = R.string.body_two),
                    backgroundColor = Color(0xFFD0BCFF),
                    modifier = modifier.weight(1f)
                )
            }
            Row(modifier.weight(1f)) {
                CardInfo(
                    title = stringResource(id = R.string.title_three), 
                    body = stringResource(id = R.string.body_three),
                    backgroundColor = Color(0xFFB69DF8) ,
                    modifier = modifier.weight(1f)
                )
                CardInfo(
                    title = stringResource(id = R.string.title_four), 
                    body = stringResource(id = R.string.body_four),
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = modifier.weight(1f)
                )
            }
        }
    }



    @Composable
    fun Page(
        modifier: Modifier
    ) {
        CardInfoQuadrant(modifier)
    }



    @Preview(showBackground = true)
    @Composable
    fun CardPreview(modifier: Modifier = Modifier){
        LearnTogetherTheme {
            Page(
                modifier
            )
        }
    }
}