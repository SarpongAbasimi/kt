package com.example.moviedb.service

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import com.example.moviedb.network.client.retrofit.RetrofitClient
import retrofit2.http.GET

interface MovieDB {
    @GET()
    suspend fun getMovies(): String

    companion object {
        fun api(baseUrl: BaseUrl, apiKey: ApiKey): MovieDB {
            return RetrofitClient.build(baseUrl, apiKey)
                .create(MovieDB::class.java)
        }
    }
}