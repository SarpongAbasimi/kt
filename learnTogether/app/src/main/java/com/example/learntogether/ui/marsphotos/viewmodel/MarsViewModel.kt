package com.example.learntogether.ui.marsphotos.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learntogether.data.repository.MarsRepository
import com.example.learntogether.model.RequestStates
import com.example.learntogether.network.MarHttpApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarsViewModel(val marsRepository: MarsRepository): ViewModel() {
    private val _uiState = MutableStateFlow<RequestStates>(RequestStates.Loading)
    val state: StateFlow<RequestStates> = _uiState.asStateFlow()

    init {
        getPhotos()
    }

    fun getPhotos(): Job {
       return viewModelScope.launch {
           try {
               val marsPhotos = marsRepository.getPhotos()
               _uiState.update { _ -> RequestStates.Success(marsPhotos) }
           } catch (error: Throwable){
               Log.e("AppError", "Error is $error")
               _uiState.update { _ -> RequestStates.Failure}
           }
       }
    }
}