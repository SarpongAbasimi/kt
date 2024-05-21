package com.example.learntogether.ui.progress

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable()
fun ProgressBarScreen(
    progressBarViewModel: ProgressBarViewModel = viewModel()
){
    val appState = progressBarViewModel.state.collectAsState()
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
            {
                println("It has been cl")
                progressBarViewModel.handleStartClick()
            }
        )
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
                    progress = currentProgress.toFloat()
                )
                Row {
                    Text(text = progressIncrement, Modifier.weight(1f), textAlign = TextAlign.Start)
                    Text(text = "100", Modifier.weight(1f),textAlign = TextAlign.End)
                }
            }
        }
}

@Composable()
fun StartResetButton(
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
        Button(onClick = handleStartClick, modifier =
        Modifier.widthIn(500.dp)) {
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