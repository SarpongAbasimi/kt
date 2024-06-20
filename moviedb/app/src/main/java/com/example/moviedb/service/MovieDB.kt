package com.example.moviedb.service

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import com.example.moviedb.model.PopularMovies
import com.example.moviedb.network.client.retrofit.RetrofitClient
import retrofit2.http.GET

interface MovieDB {
    @GET("movie/popular?language=en-US")
    suspend fun popular(): PopularMovies
    @GET("movie/now_playing")
    suspend fun nowPlaying(): PopularMovies
    @GET("movie/top_rated")
    suspend fun topRated(): PopularMovies
    @GET("movie/upcoming")
    suspend fun upComing(): PopularMovies
}

object Api {
    fun api(baseUrl: BaseUrl, apiKey: ApiKey): MovieDB {
        return RetrofitClient.build(baseUrl, apiKey)
            .create(MovieDB::class.java)
    }
}
