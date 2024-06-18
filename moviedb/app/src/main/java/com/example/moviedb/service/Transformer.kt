package com.example.moviedb.service

import com.example.moviedb.model.MovieDetails
import com.example.moviedb.model.PopularMovies
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

interface Transformer {
    fun encode(value: String): JsonElement
    fun decode(json: JsonElement): PopularMovies
    fun decodeDetails(json: JsonElement): MovieDetails
}

class TransformerService: Transformer {
    override fun encode(value: String): JsonElement {
        return Json.parseToJsonElement(value)
    }

    override fun decode(data: JsonElement): PopularMovies {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromJsonElement<PopularMovies>(data)
    }

    override fun decodeDetails(data: JsonElement): MovieDetails {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromJsonElement<MovieDetails>(data)
    }
}