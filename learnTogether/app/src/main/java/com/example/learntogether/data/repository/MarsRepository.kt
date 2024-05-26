package com.example.learntogether.data.repository

import com.example.learntogether.model.MarsPhoto
import com.example.learntogether.network.MarHttpApi

interface MarsRepository {
    suspend fun getPhotos(): List<MarsPhoto>
}

class MarsRepositoryService(private val marsHttpApi: MarHttpApi): MarsRepository {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return marsHttpApi.getPhotos()
    }
}
