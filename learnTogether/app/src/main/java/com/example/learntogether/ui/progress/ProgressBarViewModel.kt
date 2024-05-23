package com.example.learntogether.ui.progress

import androidx.lifecycle.ViewModel
import com.example.learntogether.model.ProgressBarCounter
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProgressBarViewModel: ViewModel() {

    private val MAX_COUNTER = 100
    private val _uiState: MutableStateFlow<ProgressBarCounter> =
        MutableStateFlow(ProgressBarCounter())
    val state = _uiState.asStateFlow()


    suspend fun handleStartClick(){
        while (_uiState.value.progress < MAX_COUNTER){
            delay(500L)
            _uiState.update { record ->
                record.copy(progress = _uiState.value.progress + 2)
            }
        }
    }
}