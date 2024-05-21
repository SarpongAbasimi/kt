package com.example.learntogether.ui.progress

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learntogether.model.ProgressBarCounter
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable()
fun ProgressBarScreen(
    progressBarViewModel: ProgressBarViewModel = viewModel()
){
    val appState: State<ProgressBarCounter> = progressBarViewModel.state.collectAsState()
    var isRunning: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    if(isRunning){
        HandleLaunchEffect(
            progressBarViewModel,
            { isRunning = false }
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressBar(
            Modifier,
            "Player One",
            appState.value.progress.toString(),
            appState.value.progress
        )
        Spacer(modifier = Modifier.size(10.dp))
        StartResetButton(
            Modifier,
            "Start",
            "Reset",
            { isRunning = !isRunning }
        )
    }
}
@Composable
fun HandleLaunchEffect(progressBarViewModel: ProgressBarViewModel, stateF: () -> Unit) {
    LaunchedEffect(key1 = "player1") {
        progressBarViewModel.handleStartClick()
        stateF()
    }
}

@Composable
fun ProgressBar(
    modifier: Modifier,
    playerName: String,
    progressIncrement: String,
    currentProgress: Int
){
        Row (
            modifier = modifier
        ){
            Text(text = playerName, Modifier.padding(end = 8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    progress = currentProgress / 100.toFloat()
                )
                Row {
                    Text(text = progressIncrement, Modifier.weight(1f), textAlign = TextAlign.Start)
                    Text(text = "100", Modifier.weight(1f),textAlign = TextAlign.End)
                }
            }
        }
}

@Composable()
private fun StartResetButton(
    modifier: Modifier,
    startText: String,
    resetText: String,
    handleStartClick: () -> Unit
){
    Column (
        horizontalAlignment = Alignment
            .CenterHorizontally,
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Button(onClick = handleStartClick,
            modifier = Modifier.widthIn(500.dp)) {
            Text(text = startText)
        }
        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier.widthIn(500.dp)) {
            Text(text = resetText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressBarPreview(){
    LearnTogetherTheme {
        ProgressBarScreen()
    }
}