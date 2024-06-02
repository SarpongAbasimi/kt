package com.example.learntogether.ui.inventoryui

import androidx.lifecycle.ViewModel
import com.example.learntogether.model.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddItemViewModel(private val validator: Validator): ViewModel() {
    private val _addItemUiState = MutableStateFlow<ItemState>(ItemState())
    val addItemUiState = _addItemUiState.asStateFlow()

    fun handleValueChange(input: ItemState){
       _addItemUiState.update { state: ItemState ->
           state.copy(
               name = input.name,
               price = input.price,
               quantity = input.quantity
           )
       }
    }

    fun handleValidEntry(): Boolean {
        return validator.isValidEntry(_addItemUiState.value)
    }

}