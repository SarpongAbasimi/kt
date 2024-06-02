package com.example.learntogether.ui.inventoryui

import com.example.learntogether.model.ItemState

interface Validator {
    fun isValid(state: ItemState): Boolean
}

object ValidatorImp : Validator {
    override fun isValid(state: ItemState): Boolean {
        return with(state){
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}