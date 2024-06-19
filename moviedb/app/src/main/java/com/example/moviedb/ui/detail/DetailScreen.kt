package com.example.moviedb.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedb.ui.theme.MoviedbTheme
import com.example.moviedb.ui.theme.PurpleGrey80
import com.example.moviedb.util.Util

@Composable
fun DetailsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.scrim)
    ) {
        PosterHandler(modifier = Modifier)
        TitleWithData(modifier = Modifier)
        OverView()
        PosterContent(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PosterHandler(
    imageUrl: String = "/uDosHOFFWtF5YteBRygHALFqLw2.jpg",
    modifier: Modifier
){
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = modifier.padding(bottom = 8.dp)
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
                color = PurpleGrey80 ,
                fontFamily =  FontFamily.SansSerif,
                modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}

@Composable
fun OverView(content: String = ""){
    Card(colors = CardDefaults.elevatedCardColors(
        containerColor = MaterialTheme.colorScheme.scrim
    ), modifier = Modifier.padding(0.dp)) {
        Text(text = "Po is gearing up to become the spiritual leader " +
                "of his Valley of Peace, but also needs " +
                "someone to take his place as Dragon" +
                " Warrior. As such, he will train a " +
                "new kung fu practitioner for " +
                "the spot and will encounter a " +
                "villain called the Chameleon" +
                " who conjures villains " +
                "from the past.",
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(5.dp),
            color = Color.White,
            fontFamily =  FontFamily.SansSerif
        )
    }
}

@Composable
fun PosterContent(posterPath: String = "/kDp1vUBnMpe8ak4rjgl3cLELqjU.jpg", modifier: Modifier = Modifier){
    Row {
        Card(modifier = modifier) {
            Util.ImageRequest(posterPath)
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