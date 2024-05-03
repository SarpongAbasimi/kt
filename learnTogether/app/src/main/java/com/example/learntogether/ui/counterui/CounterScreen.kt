package com.example.learntogether.ui.counterui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learntogether.R
import com.example.learntogether.ui.theme.LearnTogetherTheme


@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel(), modifier: Modifier){
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CounterCard(viewModel.counter.value, modifier)
        IncrementButton({
            viewModel.counter.value = (viewModel.counter.value.toInt() + 1).toString()
        }, modifier)
    }
}

@Composable
fun CounterCard(counter: String, modifier: Modifier){
    Text(
        text = counter,
        modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .width(30.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun IncrementButton(incrementFunc:() -> Unit, modifier: Modifier){
    Button(onClick = incrementFunc, modifier) {
       Text(text = stringResource(R.string.click_to_increase_counter))
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview(modifier: Modifier = Modifier){
    val theViewModel =  CounterViewModel()
    LearnTogetherTheme {
        CounterScreen(theViewModel, modifier)
    }
}