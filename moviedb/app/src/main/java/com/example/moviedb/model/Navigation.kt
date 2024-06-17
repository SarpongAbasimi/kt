package com.example.moviedb.model

sealed interface Navigation {
    fun name(): String
}

data object Home : Navigation {
    override fun name(): String {
        return "home"
    }
}

data object Detail: Navigation {
    override fun name(): String {
        return "detail"
    }
}