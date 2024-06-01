package com.example.learntogether.ui.inventoryui

import com.example.learntogether.data.repository.ItemRepository
import com.example.learntogether.model.ItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddItemViewModel(repository: ItemRepository) {
    private val _addItemUiState = MutableStateFlow<ItemState>(ItemState())
    val addItemUiState = _addItemUiState.asStateFlow()


}