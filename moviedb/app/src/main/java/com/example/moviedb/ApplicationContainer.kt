package com.example.moviedb

import android.app.Application
import com.example.moviedb.container.Container
import com.example.moviedb.container.DefaultContainer

class ApplicationContainer: Application() {
    lateinit var container: Container

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer
    }
}