package com.example.learntogether.ui.counterui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var counter = mutableStateOf("0")
}