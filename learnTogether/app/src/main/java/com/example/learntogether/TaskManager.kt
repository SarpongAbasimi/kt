package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class TaskManager {

    @Composable
    fun CreateManager(text: String, secondText: String, modifier: Modifier): Unit {
        val image: Painter = painterResource(id = R.drawable.ic_task_completed)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = image, contentDescription = null, modifier = modifier)
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = secondText,
                fontSize = TextUnit(16F, TextUnitType.Sp),
                modifier = modifier
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskManagerPreview(modifier: Modifier = Modifier): Unit {
        LearnTogetherTheme {
            CreateManager("All tasks completed","Nice work!",  modifier)
        }
    }
}