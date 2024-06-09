package com.example.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Calendar


@Entity
final data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String = "",
    val timestamp: String = SimpleDateFormat("yyy-MM-dd HH:mm")
        .format(Calendar.getInstance().time)
)
