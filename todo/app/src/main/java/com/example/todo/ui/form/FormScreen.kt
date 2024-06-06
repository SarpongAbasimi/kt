package com.example.todo.ui.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.R
import com.example.todo.model.FormState
import com.example.todo.ui.theme.TodoTheme

@Composable
fun FormScreen(
    handleNavigation: ()-> Unit,
    formViewModel: FormViewModel = viewModel(factory = FormViewModel.Factory)
){
    val state: FormState by formViewModel.state.collectAsState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme
                        .colorScheme.surfaceVariant
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = state.content,
                maxLines = 2,
                label = { TodoLabel(text = stringResource(R.string.what_is_on_your_mind))},
                onValueChange = {formViewModel.handleOnValueChange(it)},
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small)
                    )
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                )
            )
            ElevatedButton(onClick = { /*TODO*/ },
                modifier = Modifier.padding(top = 10.dp),
                enabled = state.isValid
            ) {
                Text(text = "Add")
            }
        }

        FloatingActionButton(onClick = handleNavigation, Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_small),
            top = dimensionResource(id = R.dimen.padding_small)
        )){
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back_arrow)
            )
        }
    }
}

@Composable
fun TodoLabel(text: String, ){
    Text(text = text, fontSize = 15.sp)
}

@Preview(showBackground = true)
@Composable
fun FormScreenPreview(){
    TodoTheme {
        FormScreen({})
    }
}