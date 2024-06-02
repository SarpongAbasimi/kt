package com.example.learntogether.ui.inventoryui

import android.icu.util.Currency
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learntogether.model.ItemState
import com.example.learntogether.ui.theme.LearnTogetherTheme
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun AddItemScreen(addViewModel: AddItemViewModel = viewModel(factory = AddItemViewModel.factory)){
    val state: ItemState by addViewModel.addItemUiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    AddItemEntryBody(
        state,
        addViewModel,
        handleSave = {
            coroutineScope.launch{
                addViewModel.handleSaveEntry()
                addViewModel.handleClearScreen()
            }
        }
    )
}

@Composable
fun AddItemEntryBody(
    state: ItemState,
    addViewModel: AddItemViewModel,
    enabled: Boolean = true,
    handleSave: () -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add Item", modifier = Modifier.padding(20.dp))
        TextFields(
            state.name,
            { name -> addViewModel.handleValueChange(state.copy(name = name))},
            "Item Name"
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextFields(
            state.price,
            { price -> addViewModel.handleValueChange(state.copy(price = price))},
            "Item Price",
            KeyboardOptions(keyboardType = KeyboardType.Decimal),
            leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) }
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextFields(
            state.quantity,
            { quantity -> addViewModel.handleValueChange(state.copy(quantity = quantity))},
            "Quantity in stock",
            KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.size(20.dp))

        if(enabled){
            Text(
                text = "*required fields",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, bottom = 15.dp),
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.size(10.dp))

        Button(
            onClick = handleSave,
            modifier = Modifier.widthIn(350.dp),
            enabled = addViewModel.handleValidEntry()
        ) {
            Text(text = "Save")
        }
    }
}


@Composable
fun TextFields(
    textInput: String,
    handleValueChange: (String)-> Unit,
    labelText:  String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
){
    OutlinedTextField(
        value = textInput ,
        onValueChange = {input -> handleValueChange(input)},
        label =  { Text(text = labelText)},
        modifier = Modifier.widthIn(350.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        keyboardOptions = keyboardOptions,
        singleLine = true,
        leadingIcon = leadingIcon,
    )
}

@Preview(showBackground = true)
@Composable
fun ThePreview(){
    LearnTogetherTheme {
        AddItemScreen()
    }
}
