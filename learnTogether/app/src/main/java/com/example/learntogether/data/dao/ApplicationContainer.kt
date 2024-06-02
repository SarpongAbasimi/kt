package com.example.learntogether.data.dao

import android.content.Context
import com.example.learntogether.data.db.InventoryDataBase
import com.example.learntogether.data.repository.ItemRepository
import com.example.learntogether.ui.inventoryui.Validator
import com.example.learntogether.ui.inventoryui.ValidatorImp

interface ApplicationContainer {
    val validator: Validator
    val repository: ItemRepository
}

class DefaultContainer(private val context: Context) : ApplicationContainer {
    private val inventoryDao =  InventoryDataBase.createDb(context).inventoryDao()

    override val validator: Validator = ValidatorImp()
    override val repository: ItemRepository = TODO()
}