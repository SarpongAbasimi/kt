package com.example.moviedb.service

import com.example.moviedb.model.PopularMovies

interface Movies {
    suspend fun popular(): PopularMovies
    suspend fun nowPlaying(): PopularMovies
    suspend fun topRated(): PopularMovies
    suspend fun upComing(): PopularMovies
}

class MoviesService(private val movieDB: MovieDB): Movies {
    override suspend fun popular(): PopularMovies {
      return movieDB.popular()
    }

    override suspend fun nowPlaying(): PopularMovies {
        return movieDB.nowPlaying()
    }

    override suspend fun topRated(): PopularMovies {
        return movieDB.topRated()
    }

    override suspend fun upComing(): PopularMovies{
        return movieDB.upComing()
    }
}