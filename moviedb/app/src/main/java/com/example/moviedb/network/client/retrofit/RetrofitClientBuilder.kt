package com.example.moviedb.network.client.retrofit

import com.example.moviedb.model.ApiKey
import com.example.moviedb.model.BaseUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


interface RetrofitClientBuilder {
    fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit
}

object RetrofitClient : RetrofitClientBuilder {
    override fun build(baseUrl: BaseUrl, apiKey: ApiKey): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient(apiKey).build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    fun okHttpClient(apiKey: ApiKey) = OkHttpClient().newBuilder().addInterceptor(
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