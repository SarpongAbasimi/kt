package com.example.moviedb.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class DetailViewModel(val transformer: Transformer, val savedStateHandle: SavedStateHandle): ViewModel() {

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
                    val encode = transformer.encode(Movies.movieDetails)
                    val decode: MovieDetails = transformer.decodeDetails(encode)
                    DetailsSuccess(decode)
                }
            } catch (error: Throwable){
                _uiState.update { Error }
            }
        }
    }
}