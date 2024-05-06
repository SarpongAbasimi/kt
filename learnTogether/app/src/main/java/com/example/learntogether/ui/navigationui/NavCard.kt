package com.example.learntogether.ui.navigationui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.learntogether.R

@Composable
fun NavCard(
    cardData: String,
    modifier: Modifier,
    onNextClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
){
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardScreen(cardData, modifier.weight(2f).background(Color.LightGray))
        Row(modifier = Modifier.weight(1f).fillMaxSize().background(Color.Cyan),
             horizontalArrangement = Arrangement.Center
            ) {
            Button(onClick = onBackClick) {
                Text(text = stringResource(R.string.back))
            }
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = onNextClick) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}
