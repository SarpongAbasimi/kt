package com.example.learntogether.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learntogether.data.dao.InventoryDao
import com.example.learntogether.model.Item

@Database(entities = arrayOf(Item::class), version = 2, exportSchema = false)
abstract class InventoryDataBase : RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao

    companion object {
        fun createDb(context: Context):InventoryDataBase  {
            return Room.databaseBuilder(
                context,
                InventoryDataBase::class.java,
                "item_database_new"
            ).build()
        }
    }
}