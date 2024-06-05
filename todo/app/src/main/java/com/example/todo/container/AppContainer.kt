package com.example.todo.container

import android.content.Context
import com.example.todo.dao.TodoDao
import com.example.todo.database.AppDb
import com.example.todo.repository.TodoRepository
import com.example.todo.repository.TodoRepositoryImpl
import com.example.todo.services.Validator
import com.example.todo.services.ValidatorService

interface AppContainer {
    val repository: TodoRepository
    val validator: Validator
}

class Container(context: Context): AppContainer {
    private val dao: TodoDao = AppDb.create("todo_app", context).todoDao()

    override val repository = TodoRepositoryImpl(dao)
    override val validator: Validator = ValidatorService()
}