package com.example.learntogether.ui.inventoryui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme
import androidx.compose.runtime.Composable

@Composable
fun AddItemScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add Item", modifier = Modifier.padding(20.dp))
        TextFields("dfd", { it -> println(it) }, "Item Name")
        Spacer(modifier = Modifier.size(20.dp))
        TextFields("aa", { it -> println(it) }, "Item Price")
        Spacer(modifier = Modifier.size(20.dp))
        TextFields("aa", { it -> println(it) }, "Quantity in stock")
        Spacer(modifier = Modifier.size(20.dp))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.widthIn(350.dp)) {
            Text(text = "Save")
        }
    }
}


@Composable
fun TextFields(
    textInput: String,
    handleValueChange: (String)-> Unit,
    labelText:  String
){
    OutlinedTextField(
        value = textInput ,
        onValueChange = handleValueChange,
        label =  { Text(text = labelText)},
        modifier = Modifier.widthIn(350.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ThePreview(){
    LearnTogetherTheme {
        AddItemScreen()
    }
}
