package com.example.learntogether.ui.radio

import androidx.lifecycle.ViewModel
import com.example.learntogether.model.CupCakeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CupCakeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<CupCakeState>(CupCakeState())
    var state: StateFlow<CupCakeState> = _uiState.asStateFlow()

    fun updateQuantity(value: Int){
        _uiState.update { cupcake ->
            cupcake.copy(quantity = value)
        }
    }
}