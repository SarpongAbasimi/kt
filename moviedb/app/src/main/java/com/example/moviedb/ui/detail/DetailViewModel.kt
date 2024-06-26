package com.example.moviedb.ui.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.moviedb.ApplicationContainer
import com.example.moviedb.dummy.Movies
import com.example.moviedb.model.DetailsSuccess
import com.example.moviedb.model.Error
import com.example.moviedb.model.Loading
import com.example.moviedb.model.MovieDetails
import com.example.moviedb.model.ScreenState
import com.example.moviedb.service.Transformer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    val savedStateHandle: SavedStateHandle,
    val movies: com.example.moviedb.service.Movies
): ViewModel() {

    private val id: String = checkNotNull( savedStateHandle["id"])
    private val _uiState = MutableStateFlow<ScreenState>(Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getMovie(id)
    }
    fun getMovie(id: String){
        viewModelScope.launch {
            try {
                _uiState.update {
                    val result = movies.getMovie(id.toInt())
                    DetailsSuccess(result)
                }
            } catch (error: Throwable){
                Log.d("DetailsError", "$error")
                _uiState.update { Error }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val container = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ApplicationContainer).container

                DetailViewModel(this.createSavedStateHandle(),container.movies)

            }
        }
    }
}