package com.example.todo.ui.edit


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.model.Todo
import com.example.todo.ui.theme.TodoTheme


@Composable
fun EditScreen(
    viewModel: EditViewModel = viewModel(factory = EditViewModel.Factory)
){
    val state: Todo by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = state.content,
            onValueChange = {
                viewModel
                    .handleOnValueChange(it)
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview(){
    TodoTheme {
        EditScreen()
    }
}