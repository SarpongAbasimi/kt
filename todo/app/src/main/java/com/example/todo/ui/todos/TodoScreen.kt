package com.example.todo.ui.todos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.R
import com.example.todo.model.TodosState
import com.example.todo.ui.theme.TodoTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.unit.dp

@Composable
fun TodoScreen(
    handleNavigation:()-> Unit,
    viewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)
){
    val todoState: TodosState by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme
                    .colorScheme
                    .onBackground
            )
            .padding(top = dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(todoState.value, key = {data -> data.id}){ data ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                    modifier = Modifier
                        .size(width = 340.dp, height = 100.dp)
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_mini),
                            start = dimensionResource(id = R.dimen.padding_mini)
                        )
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(id = R.dimen.padding_mini))
                    ) {
                        Text(text = data.content)
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = handleNavigation,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom =
                    dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium)
                )
        ){
            Icon(Icons.Filled.Add,
                stringResource(R.string.floating_action_button),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview(){
    TodoTheme {
        TodoScreen({})
    }
}