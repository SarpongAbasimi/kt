package com.example.learntogether.clients

import com.example.learntogether.model.BaseUrl
import com.example.learntogether.network.MarHttpApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object HttpClient {
    fun  build(url: BaseUrl): MarHttpApi {
       val retrofit = Retrofit.Builder()
           .addConverterFactory(
               Json
                   .asConverterFactory(
                       "application/json".toMediaType()
                   )
           )
            .baseUrl(url.value)
            .build()
        return retrofit.create(MarHttpApi::class.java)
    }
}