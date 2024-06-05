package com.example.todo.ui.todos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.R
import com.example.todo.ui.theme.TodoTheme

@Composable
fun TodoScreen(handleNavigation:()-> Unit){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme
                    .colorScheme
                    .onBackground
            )
        ) {

        }

        FloatingActionButton(
            onClick = handleNavigation,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom =
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