package com.example.moviedb.model

data class HomeScreenState(
    val popularMovies: PopularMovies,
    val topRatedMovies: PopularMovies,
    val nowPlaying: PopularMovies,
    val upComing: PopularMovies,
    val popularMoviesSize: Int = 0
)
