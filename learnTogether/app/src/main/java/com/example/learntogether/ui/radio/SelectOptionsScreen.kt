package com.example.learntogether.ui.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable
fun SelectOptionScreen(
    data: List<String> = listOf<String>(),
    onHandleClick: ()-> Unit = {},
    subtotal: String
){
    Column(Modifier.fillMaxSize()) {
        data.forEach { text ->
            OptionsCards(onHandleClick, text)
        }

        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp)
            )
        Text(
            text = subtotal,
            Modifier.align(Alignment.End).padding(end = 18.dp),
        )
    }
}

@Composable
fun OptionsCards(
    handleOnClick: () -> Unit,
    radioButtonText: String
){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(selected = false, onClick = handleOnClick)
            Text(text = radioButtonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectOptionPreview(){
    LearnTogetherTheme {
        SelectOptionScreen(
            listOf(
                "Rice and Chicken",
                "Kenkey and Fish",
                "Banku", "Gob3"
            ),
            subtotal = "Subtotal $2900"
        )
    }
}

