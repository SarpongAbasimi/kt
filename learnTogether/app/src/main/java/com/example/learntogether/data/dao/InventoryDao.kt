package com.example.learntogether.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learntogether.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(input: Item): Unit

    @Query("SELECT * FROM item WHERE id= :id")
    fun find(id: Int): Flow<Item>

    @Query("SELECT * FROM item")
    fun get(): Flow<List<Item>>
}