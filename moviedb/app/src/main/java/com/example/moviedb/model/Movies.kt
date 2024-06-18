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
data class BelongsToCollection(
    val id: Int,
    val name: String,
    @SerialName(value = "poster_path")
    val posterPath: String,
    @SerialName(value = "backdrop_path")
    val backdropPath: String
)

@Serializable
data class Genre(
    val id: Int,
    val name: String
)

@Serializable
data class MovieDetails(
    @SerialName(value = "backdrop_path")
    val backdropPath: String,
    @SerialName(value = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    val budget: Int,
    @SerialName(value = "origin_country")
    val originCountry: List<String>,
    @SerialName(value = "original_language")
    val originalLanguage: String,
    @SerialName(value = "original_title")
    val originalTitle: String,
    val overview: String,
    @SerialName(value = "poster_path")
    val posterPath: String,
    @SerialName(value = "release_date")
    val releaseDate: String,
    val status: String,
    val genres: List<Genre>
)


@Serializable
data class PopularMovies(
    val page: Int,
    val results: List<PopularMoviesResult>,
    val dates: Dates? = null
)
