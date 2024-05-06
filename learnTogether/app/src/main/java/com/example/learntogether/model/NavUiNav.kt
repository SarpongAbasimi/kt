package com.example.learntogether.model


import androidx.annotation.StringRes
import com.example.learntogether.R

enum class NavUiNav(@StringRes val input: Int){
    NavOne(input = R.string.one),
    NavTwo(input = R.string.two),
    NavThree(input = R.string.three)
}