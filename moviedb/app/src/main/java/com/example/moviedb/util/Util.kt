package com.example.moviedb.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

object Util {
    private val BaseUrl = "https://image.tmdb.org/t/p/original"

    @Composable
    fun ImageRequest(url: String){
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data("$BaseUrl$url")
                .crossfade(true)
                .build()
            ,
            contentDescription = null
        )
    }
}