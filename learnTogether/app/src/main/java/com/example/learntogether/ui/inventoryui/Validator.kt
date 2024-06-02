package com.example.learntogether.ui.inventoryui

import com.example.learntogether.model.ItemState

interface Validator {
    fun isValidEntry(state: ItemState): Boolean
}

class ValidatorImp : Validator {
    override fun isValidEntry(state: ItemState): Boolean {
        return with(state){
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}