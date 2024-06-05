package com.example.todo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todo.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo where id = :id")
    fun find(id: Int): Flow< Todo>

    @Query("SELECT * FROM todo ORDER BY timestamp ASC")
    fun getAll(): Flow<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo): Unit

    @Delete
    suspend fun delete(todo: Todo): Unit

    @Update
    suspend fun edit(todo: Todo): Unit

}