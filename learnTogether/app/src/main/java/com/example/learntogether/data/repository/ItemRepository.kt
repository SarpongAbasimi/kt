package com.example.learntogether.data.repository

import com.example.learntogether.data.dao.InventoryDao
import com.example.learntogether.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun insert(input: Item): Unit

    suspend fun find(id: Int): Flow<Item>

    suspend fun get(): Flow<List<Item>>
}


class ItemRepositoryImp(private val inventoryDao: InventoryDao): ItemRepository {
    override suspend fun insert(input: Item): Unit {
        return inventoryDao.insert(input)
    }

    override suspend fun find(id: Int): Flow<Item> {
        return inventoryDao.find(id)
    }

    override suspend fun get(): Flow<List<Item>> {
       return inventoryDao.get()
    }

}