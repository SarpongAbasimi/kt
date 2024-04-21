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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class Dice {
    @Composable
    fun DiceApp(modifier: Modifier = Modifier) {
        var tracker by remember { mutableStateOf(1) }

        val imageResource: Int = when (tracker) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Random.nextInt(1,6)
        Column(
            modifier
                .fillMaxSize()
                .wrapContentSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "You played ${tracker} 😊")

            Image(painter = painterResource(id = imageResource) , contentDescription = "dice")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { tracker = Random.nextInt(1,6) }) {
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