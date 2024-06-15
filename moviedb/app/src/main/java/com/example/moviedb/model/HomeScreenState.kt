package com.example.moviedb.model

data class HomeScreenState(
    val popularMovies: PopularMovies,
    val popularMoviesSize: Int = 0
)
