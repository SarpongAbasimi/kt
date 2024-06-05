package com.example.todo.ui.form

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.FormState
import com.example.todo.model.Todo
import com.example.todo.repository.TodoRepository
import com.example.todo.services.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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
}