package com.example.moviedb.model

sealed interface ScreenState

data object Loading: ScreenState
data object Error: ScreenState
data class Success(val homeScreenState: HomeScreenState): ScreenState
