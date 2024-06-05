package com.example.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.dao.TodoDao
import com.example.todo.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}

object AppDb {
    fun create(dbName:String, context:Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, dbName
        ).build()
    }
}