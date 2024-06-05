package com.example.todo.repository

import com.example.todo.dao.TodoDao
import com.example.todo.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun find(id: Int): Flow<Todo>

    fun getAll(): Flow<List<Todo>>

    suspend fun insert(todo: Todo): Unit

    suspend fun delete(todo: Todo): Unit

    suspend fun edit(todo: Todo): Unit
}

class TodoRepositoryImpl(val dao: TodoDao): TodoRepository {

    override fun find(id: Int): Flow<Todo> {
       return dao.find(id)
    }

    override fun getAll(): Flow<List<Todo>> {
        return dao.getAll()
    }

    override suspend fun insert(todo: Todo) {
        return dao.insert(todo)
    }

    override suspend fun delete(todo: Todo) {
        return dao.delete(todo)
    }

    override suspend fun edit(todo: Todo) {
       return dao.edit(todo)
    }

}