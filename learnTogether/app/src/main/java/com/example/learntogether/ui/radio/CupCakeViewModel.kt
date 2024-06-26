package com.example.learntogether.ui.radio

import androidx.lifecycle.ViewModel
import com.example.learntogether.model.CupCakeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CupCakeViewModel: ViewModel() {
    /** Price for a single cupcake */
    private val PRICE_PER_CUPCAKE: Double = 2.00

    private val _uiState = MutableStateFlow<CupCakeState>(CupCakeState())
    var state: StateFlow<CupCakeState> = _uiState.asStateFlow()

    fun updateQuantity(value: Int){
        _uiState.update { cupcake: CupCakeState ->
            cupcake.copy(
                quantity = value,
                price = calculateTotal(value)
            )
        }
    }

    fun updateFlavour(flavour: String){
        _uiState.update { cupcake ->
            cupcake.copy(
                flavour = flavour
            )
        }
    }

    fun updateOrderData(orderDate: String){
        _uiState.update { cupCake: CupCakeState ->
            cupCake.copy(
                orderDate = orderDate
            )
        }
    }

    private fun calculateTotal(quantity: Int): Double {
     return PRICE_PER_CUPCAKE * quantity
    }

}