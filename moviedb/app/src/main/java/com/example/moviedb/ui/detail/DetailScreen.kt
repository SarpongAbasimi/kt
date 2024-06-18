package com.example.moviedb.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedb.ui.theme.MoviedbTheme
import com.example.moviedb.util.Util

@Composable
fun DetailsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.scrim)
    ) {
        PosterHandler(modifier = Modifier)
        TitleWithData(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PosterHandler(
    imageUrl: String = "/uDosHOFFWtF5YteBRygHALFqLw2.jpg",
    modifier: Modifier
){
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = modifier.padding(bottom = 5.dp)
    ) {
        Util.ImageRequest(imageUrl)
    }
}

@Composable
fun TitleWithData(modifier: Modifier){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Kung Fu Panda 4",
            color = Color.White,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

        Row {
            listOf("Action", "Family", "Comedy", "Fantasy").forEach{
                genre ->
                Text(
                text = genre,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
fun DetailsScreenPreview(){
    MoviedbTheme {
        DetailsScreen()
    }
}