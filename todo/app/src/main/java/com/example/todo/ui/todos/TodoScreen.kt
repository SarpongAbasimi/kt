package com.example.todo.ui.todos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TodoScreen(
    handleNavigation:()-> Unit,
    viewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)
){
    val todoState: TodosState by viewModel.state.collectAsState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

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
            items(todoState.value, key = {data -> data.id}){ data: Todo ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                    modifier = Modifier
                        .height(height = 100.dp)
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_mini),
                            start = dimensionResource(id = R.dimen.padding_small),
                            end = dimensionResource(id = R.dimen.padding_small)
                        )
                ) {
                    Box {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(dimensionResource(id = R.dimen.padding_small))
                        ) {
                            Text(text = data.content, fontSize = 20.sp, fontFamily = FontFamily.Serif)
                            Row(modifier = Modifier
                                .padding(top = 5.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(text = "CreatedAt |", fontSize = 14.sp, modifier = Modifier.padding(end = 5.dp))
                                Text(text = data.timestamp, fontSize = 14.sp)
                            }
                        }

                        DeleteAndEdit(
                            data,
                            viewModel,
                            {},
                            coroutineScope,
                            deleteModifier = Modifier.align(Alignment.BottomEnd),
                            editModifier =  Modifier.align(Alignment.BottomEnd),
                            rowModifier = Modifier.align(Alignment.BottomEnd)
                        )
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

@Composable
private fun DeleteAndEdit(
    data: Todo,
    viewModel: TodoViewModel,
    handleOnClickEdit: () -> Unit,
    coroutineScope: CoroutineScope,
    deleteModifier: Modifier,
    editModifier: Modifier,
    rowModifier: Modifier
){
    Row(modifier = rowModifier) {
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    viewModel.handleDelete(data)
                }
            },
            modifier = deleteModifier.padding(4.dp).size(35.dp),
            containerColor = Color.Unspecified
        ) {
            Icon(Icons.Filled.Delete,
                stringResource(R.string.floating_action_button_delete)
            )
        }

        FloatingActionButton(
            onClick = { handleOnClickEdit() },
            modifier = editModifier.padding(4.dp).size(35.dp),
            containerColor = Color.Unspecified
        ) {
            Icon(Icons.Filled.Edit,
                stringResource(R.string.edit_button_icon)
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