package com.example.todo.ui.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.R
import com.example.todo.ui.theme.TodoTheme

@Composable
fun FormScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme
            .colorScheme.surfaceVariant
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = "",
            label = { TodoLabel(text = "What is on your mind")},
            onValueChange = {},
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                    end = dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
        ElevatedButton(onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Add")
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
        FormScreen()
    }
}