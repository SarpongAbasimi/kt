package com.example.moviedb.network.client.retrofit

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit


interface RetrofitClientBuilder {
    fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit
}

object RetrofitClient : RetrofitClientBuilder {
    override fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(Json{ ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient(apiKey).build())
            .build()
    }

    private fun okHttpClient(apiKey: ApiKey) = OkHttpClient().newBuilder().addInterceptor(
        object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request = chain.request()
                    .newBuilder()
                    .header("accept", "application/json")
                    .header("Authorization", "${apiKey.value}")
                    .build()
                return chain.proceed(request)
            }
        }
    )

}