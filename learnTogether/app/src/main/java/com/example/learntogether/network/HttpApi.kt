package com.example.learntogether.network

import com.example.learntogether.model.MarsPhoto
import retrofit2.http.GET

interface MarHttpApi {
    @GET("/photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
