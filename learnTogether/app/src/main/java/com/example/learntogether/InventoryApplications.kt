package com.example.learntogether

import android.app.Application
import com.example.learntogether.data.dao.ApplicationContainer
import com.example.learntogether.data.dao.DefaultContainer

class InventoryApplications: Application() {
    lateinit var container: ApplicationContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer(this)
    }
}