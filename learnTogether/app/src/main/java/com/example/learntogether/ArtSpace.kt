package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class ArtSpace {

    @Composable
    fun ArtSpaceApp(){
        var pageTrackerState: Int by remember {
            mutableStateOf(1)
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            when(pageTrackerState) {
                1 -> {
                    ArtWorkWall(Modifier
                        .weight(4f)
                        .fillMaxWidth(),
                        R.drawable.ic_task_completed
                    )
                    ArtWorkDescriptor(
                        "Still Life Of Blue Rose and Other Flowers",
                        "Artwork Artist (2021)", Modifier.weight(1f)
                    )
                }
                2 -> {
                    ArtWorkWall(Modifier.
                    weight(4f)
                        .fillMaxWidth(),
                        R.drawable.ic_launcher_background
                    )
                    ArtWorkDescriptor(
                        "This is number two By Sir Alan",
                        "Artwork Artist (2022)", Modifier.weight(1f)
                    )
                }
                else -> {
                    ArtWorkWall(Modifier
                        .weight(4f)
                        .fillMaxWidth(),
                        R.drawable.dice_3
                    )
                    ArtWorkDescriptor("This is number three by Bryan",
                        "Artwork Artist (2023)", Modifier.weight(1f))
                }
            }

            AppButtons(
                "Previous",
                "Next",
                Modifier.weight(0.5f),
                onClickPrevious = { if(pageTrackerState > 1) pageTrackerState-- else pageTrackerState },
                onClickNext = { if(pageTrackerState < 3) pageTrackerState++ else pageTrackerState }
            )
        }
    }

    @Composable
    fun ArtWorkWall(modifier: Modifier, imageId: Int) {
        val image = painterResource(id = imageId)
        Image(painter = image, contentDescription = null, modifier)
    }

    @Composable
    fun ArtWorkDescriptor(artWorkTitle:String, artist: String, modifier: Modifier){
        Column(
            modifier
                .padding(10.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = artWorkTitle,
                fontSize = 28.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(10.dp)
            )
            Text(text = artist, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
        }
    }

    @Composable
    fun AppButtons(
        buttonOneTitle: String,
        buttonTwoTitle: String,
        modifier: Modifier,
        onClickPrevious: ()-> Unit,
        onClickNext: () -> Unit
        )
    {
        Row(
            modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly

        ) {
            Button(onClick =  onClickPrevious) {
                Text(text = buttonOneTitle)
            }
            Button(onClick = onClickNext) {
                Text(text = buttonTwoTitle)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ArtSpacePreview(){
        LearnTogetherTheme {
            ArtSpaceApp()
        }
    }
}