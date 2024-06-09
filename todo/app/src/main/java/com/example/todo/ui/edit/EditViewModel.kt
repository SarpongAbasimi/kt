package com.example.todo.ui.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todo.ApplicationContainer
import com.example.todo.container.AppContainer
import com.example.todo.model.Todo
import com.example.todo.repository.Repository
import com.example.todo.services.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditViewModel(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle,
    private val validator: Validator
): ViewModel(){

    private val id: String = checkNotNull(savedStateHandle["id"])
    private val _editTodoState = MutableStateFlow<Todo>(Todo())
    val state = _editTodoState.asStateFlow()

    init {
        viewModelScope.launch {
            handleEditGetTodo(id.toInt())
        }
    }

    fun handleOnValueChange(content: String){
        _editTodoState.update { todo ->
            todo.copy(content = content)
        }
    }

    private suspend fun handleEditGetTodo(id: Int){
        repository.find(id).collect { data ->
            _editTodoState.update {
                it.copy(id = data.id, content = data.content)
            }
        }
    }


    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val container: AppContainer = (this[APPLICATION_KEY] as ApplicationContainer).container
                val repository: Repository = container.repository
                val validator: Validator = container.validator

                EditViewModel(repository, this.createSavedStateHandle(), validator)
            }
        }
    }
}