package com.example.moviedb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
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
    val voteCount: Int,
    @SerialName(value ="backdrop_path")
    val backdropPath: String
)

@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)


@Serializable
data class PopularMovies(
    val page: Int,
    val results: List<PopularMoviesResult>,
    val dates: Dates? = null
)
