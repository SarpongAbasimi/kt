package com.example.todo

import android.app.Application
import com.example.todo.container.AppContainer
import com.example.todo.container.Container

class ApplicationContainer: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = Container(this)
    }
}