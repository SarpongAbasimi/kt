package com.example.moviedb.container

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import com.example.moviedb.service.Api
import com.example.moviedb.service.FileReader
import com.example.moviedb.service.FileReaderService
import com.example.moviedb.service.Movies
import com.example.moviedb.service.MoviesService
import com.example.moviedb.service.TransformerService

interface Container {
    val fileReader: FileReader
    val transformer: TransformerService
    val movies: Movies
}

object DefaultContainer : Container {
    private val baseUrl: BaseUrl = BaseUrl("https://api.themoviedb.org/3/")
    private val apiKey: ApiKey = ApiKey("")
    private val movieDb = Api.api(baseUrl, apiKey)

    override val fileReader: FileReader = FileReaderService()
    override val transformer: TransformerService = TransformerService()
    override val movies: Movies = MoviesService(movieDb)
}