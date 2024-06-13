package com.example.moviedb.model

import kotlinx.serialization.SerialName


data class PopularMoviesResult(
    val id: Int,
    @SerialName(value = "original_language")
    val originalLanguage: String,
    @SerialName(value = "original_title")
    val originalTitle: String,
    val overview: String,
    @SerialName(value = "poster_path")
    val posterPath: String,
    val title: String,
    val video: Boolean,
    @SerialName(value = "vote_average")
    val voteAverage: Double,
    @SerialName(value = "vote_count")
    val voteCount: Int
)


data class PopularMovies(val page: Int, val results: List<PopularMoviesResult>)
