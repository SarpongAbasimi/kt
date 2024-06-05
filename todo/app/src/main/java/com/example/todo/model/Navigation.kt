package com.example.todo.model

sealed interface Navigation {
    fun name(): String
}

 data object Todos: Navigation {
    override fun name(): String {
        return "todos"
    }
}

 data object AddTodo: Navigation {
    override fun name(): String {
        return "addTodo"
    }
}