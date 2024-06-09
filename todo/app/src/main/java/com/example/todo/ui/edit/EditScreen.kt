package com.example.todo.ui.edit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.ui.theme.TodoTheme


@Composable
fun EditScreen(){
    Text(text = "This is it")
}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview(){
    TodoTheme {
        EditScreen()
    }
}