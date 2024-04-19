package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Dice {
    @Composable
    fun DiceApp(modifier: Modifier = Modifier) {
        Column(
            modifier
                .fillMaxSize()
                .wrapContentSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = R.drawable.dice_1) , contentDescription = "dice")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {  }) {
                Text(text = stringResource(R.string.roll))
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun DicePreview(modifier: Modifier = Modifier){
        DiceApp(modifier)
    }
}