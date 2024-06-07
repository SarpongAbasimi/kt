package com.example.todo.ui.todos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todo.ApplicationContainer
import com.example.todo.model.Todo
import com.example.todo.model.TodosState
import com.example.todo.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: Repository): ViewModel(){

    private val _todoState = MutableStateFlow(TodosState())
    val state = _todoState.asStateFlow()

    init {
        viewModelScope .launch {
            getAll()
        }
    }

    suspend private fun getAll(){
        repository.getAll().collect { data: List<Todo> ->
            _todoState.update { state: TodosState -> state.copy(value = data)}
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val myRepository = (this[APPLICATION_KEY] as ApplicationContainer)
                    .container
                    .repository

                TodoViewModel(myRepository)
            }
        }
    }
}