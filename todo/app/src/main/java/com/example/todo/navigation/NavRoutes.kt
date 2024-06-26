package com.example.todo.navigation

import com.example.todo.model.Add
import com.example.todo.model.Edit
import com.example.todo.model.Navigation
import com.example.todo.model.Todos

interface NavRoutes {
    fun build(navigation: Navigation): String
}

class NavigationService: NavRoutes {
   override fun build(navigation: Navigation): String {
        return when(val nav = navigation){
            Todos -> nav.name()
            Add -> nav.name()
            Edit -> nav.name()
        }
    }
}