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
            .baseUrl("""
                ${baseUrl.url}?api_key=${apiKey.value}&append_to_response=&append_to_response=videos,images
                """.trimIndent())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

}