package com.example.moviedb.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.ui.theme.MoviedbTheme

@Composable
fun DetailsScreen(){
    Text(text = "Hello")
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    MoviedbTheme {
        DetailsScreen()
    }
}