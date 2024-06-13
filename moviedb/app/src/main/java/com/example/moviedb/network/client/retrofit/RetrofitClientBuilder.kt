package com.example.moviedb.network.client.retrofit

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


interface RetrofitClientBuilder {
    fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit
}

object RetrofitClient : RetrofitClientBuilder {
    override fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

}