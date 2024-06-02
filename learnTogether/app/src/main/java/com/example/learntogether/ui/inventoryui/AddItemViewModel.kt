package com.example.learntogether.ui.inventoryui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.learntogether.InventoryApplications
import com.example.learntogether.data.repository.ItemRepository
import com.example.learntogether.model.Item
import com.example.learntogether.model.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddItemViewModel(
    private val validator: Validator,
    private val repository: ItemRepository
): ViewModel() {
    private val _addItemUiState = MutableStateFlow<ItemState>(ItemState())
    val addItemUiState: StateFlow<ItemState> = _addItemUiState.asStateFlow()

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

    suspend fun handleSaveEntry(): Unit{
        if(handleValidEntry()) {
            return with(_addItemUiState.value){
                repository
                    .insert(
                        Item(
                            price = price.toDouble(),
                            quantity =
                            quantity.toInt())
                    )
            }
        }
    }

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application: InventoryApplications = (this[APPLICATION_KEY] as InventoryApplications)
                val repository = application.container.repository
                val validator = application.container.validator

                AddItemViewModel(validator, repository)
            }
        }
    }

}