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


class HomeViewModel(val movies: com.example.moviedb.service.Movies): ViewModel() {
    private val _state = MutableStateFlow<ScreenState>(Loading)
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    init {
        read()
    }


    private fun read(){
        viewModelScope.launch {
            try {
                _state.update {

                    val popularMovies = movies.popular()
                    val nowPlaying = movies.nowPlaying()
                    val topRated = movies.topRated()
                    val upComing = movies.upComing()

                    val moviesList =  listOf(popularMovies, nowPlaying, topRated, upComing)

                    Success(
                        HomeScreenState(
                            popularMovies,
                            topRated,
                            nowPlaying,
                            upComing,
                            handleHorizontalPager(moviesList),
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

    private fun handleHorizontalPager(input: List<PopularMovies>): PopularMovies{
        return input.shuffled().random()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                 val container = (this[APPLICATION_KEY] as ApplicationContainer).container

                HomeViewModel(container.movies)
            }
        }
    }
}
