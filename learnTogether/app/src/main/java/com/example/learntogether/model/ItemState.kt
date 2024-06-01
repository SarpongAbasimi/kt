package com.example.learntogether.model

import androidx.room.PrimaryKey

data class ItemState(
    val id:Int = 0,
    val price: Double = 0.0,
    val quantity: Int = 0
)