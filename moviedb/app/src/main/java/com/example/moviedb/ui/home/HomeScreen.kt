package com.example.moviedb.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.ui.theme.MoviedbTheme


@Composable
fun HomeScreen(){
    Text(text = "Hello")
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    MoviedbTheme {
        HomeScreen()
    }
}