package com.example.learntogether.ui.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable
fun SelectOptionScreen(
    data: List<String> = listOf(),
    subtotal: String = "",
    onClickCancel: () -> Unit = {},
    onClickNext: () -> Unit = {},
    modifier: Modifier = Modifier
){
    var selectOptionState: String by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        data.forEach { text ->
            OptionsCards({
                selectOptionState = text
            }, text, selectOptionState)
        }

        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp)
            )
        Text(
            text = subtotal,
            Modifier
                .align(Alignment.End)
                .padding(
                    top = 18.dp,
                    bottom = 18.dp,
                    end = 10.dp
                )
        )

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(onClick = onClickCancel, modifier = Modifier.weight(1f)) {
                Text(text = "Cancel")
            }
            Button(onClick = onClickNext, modifier = Modifier.weight(1f)) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun OptionsCards(
    handleOnClick: () -> Unit,
    radioButtonText: String,
    state: String
){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = radioButtonText == state,
                onClick = handleOnClick
            )
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

