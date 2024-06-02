package com.example.learntogether.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val price: Double,
    val quantity: Int
)
