package com.example.learntogether.ui.counterui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<CounterUiState> = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    fun increaseCounter(): Unit {
        _uiState.update { state ->
            state.copy(counter = state.counter + 1)
        }
    }
}