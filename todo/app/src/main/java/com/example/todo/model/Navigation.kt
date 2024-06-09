package com.example.todo.model

sealed interface Navigation {
    fun name(): String
}

 data object Todos: Navigation {
    override fun name(): String {
        return "todos"
    }
}

 data object Add: Navigation {
    override fun name(): String {
        return "add"
    }
}

data object Edit: Navigation{
    override fun name(): String {
        return "edit/{id}"
    }
}