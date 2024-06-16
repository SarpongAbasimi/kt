package com.example.moviedb.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.moviedb.ApplicationContainer
import com.example.moviedb.dummy.Movies
import com.example.moviedb.model.Error
import com.example.moviedb.model.HomeScreenState
import com.example.moviedb.model.Loading
import com.example.moviedb.model.PopularMovies
import com.example.moviedb.model.ScreenState
import com.example.moviedb.model.Success
import com.example.moviedb.service.Transformer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(val transformer: Transformer): ViewModel() {
    private val _state = MutableStateFlow<ScreenState>(Loading)
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    init {
        read()
    }


    private fun read(){
        viewModelScope.launch {
            try {
                _state.update {
                    val popularMovies = getData(Movies.popular)
                    val nowPlaying = getData(Movies.nowPlaying)
                    val topRated = getData(Movies.topRated)
                    val upComing = getData(Movies.upComing)

                    Success(
                        HomeScreenState(
                            popularMovies,
                            topRated,
                            nowPlaying,
                            upComing,
                            popularMovies.results.size
                        )
                    )
                }
            } catch (error: Throwable){
                Log.d("MyError", "$error")
                _state.update { Error}
            }

        }
    }


    private fun getData(input: String): PopularMovies {
        val encode = transformer.encode(input)
        return  transformer.decode(encode)
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                 val container = (this[APPLICATION_KEY] as ApplicationContainer).container

                HomeViewModel(container.transformer)
            }
        }
    }
}
