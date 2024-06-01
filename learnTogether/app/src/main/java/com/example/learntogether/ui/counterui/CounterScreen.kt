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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
fun CounterScreen(modifier: Modifier, viewModel: CounterViewModel = viewModel()){
    val appState: CounterUiState by viewModel.uiState.collectAsState()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CounterCard(appState.counter, modifier)
        IncrementButton(
            { viewModel.increaseCounter() },
            modifier
        )
    }
}

@Composable
fun CounterCard(counter: Int, modifier: Modifier){
    Text(
        text = counter.toString(),
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
    LearnTogetherTheme {
        CounterScreen(modifier)
    }
}