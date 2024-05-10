package com.example.learntogether.ui.radio

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.data.CupCakeDataSource
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable
fun StartOrderScreen(
    data: List<Pair<Int, Int>>,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cupcakes", Modifier.padding(bottom = 15.dp))
        Column {
            data.forEach {item ->
                SelectQuantityButton(item.first, onNextClick)
            }
        }
    }
}

@Composable
fun SelectQuantityButton(
    @StringRes data: Int,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onNextClick,
        Modifier.widthIn(min = 250.dp)
    ) {
        Text(text = stringResource(data), modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun StartOrderScreenPreview(){
    LearnTogetherTheme {

        StartOrderScreen(
            CupCakeDataSource.cupCakeQuantityOptions,
            {}
        )
    }
}