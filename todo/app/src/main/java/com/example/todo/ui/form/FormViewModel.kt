package com.example.todo.ui.form

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todo.model.FormState
import com.example.todo.model.Todo
import com.example.todo.repository.TodoRepository
import com.example.todo.services.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.todo.ApplicationContainer
import com.example.todo.container.AppContainer

class FormViewModel(val repository: TodoRepository, val validator: Validator): ViewModel() {
    private val _state: MutableStateFlow<FormState> = MutableStateFlow<FormState>(FormState())
    val state: StateFlow<FormState> = _state.asStateFlow()

    fun handleFormSubmit() {
        if(validator.validate(_state.value)){
            try {
                viewModelScope.launch {
                    repository.insert(Todo(content = state.value.content))
                }
            } catch (e: Throwable) {
                Log.e("TodoFormViewModel", "And error occurred whiles inserting data $e")
            }

        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val container: AppContainer = (this[APPLICATION_KEY] as ApplicationContainer).container
                FormViewModel(container.repository, container.validator)
            }
        }
    }
}