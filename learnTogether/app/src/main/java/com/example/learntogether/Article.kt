package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class Article {

    @Composable
    fun Page(title: String, firstText: String, lastText: String, modifier: Modifier){
        Column(modifier) {
            LearnTogetherImage(modifier)
            LearnTogetherTitle(title)
            LearnTogetherFirstParagraph(firstText, modifier)
            LearnTogetherLastParagraph(lastText, modifier)
        }
    }

    @Composable
    fun LearnTogetherImage(modifier: Modifier = Modifier): Unit {
        val image = painterResource(id = R.drawable.bg_compose_background)
        Image(painter = image, contentDescription = null, modifier = modifier)
    }

    @Composable
    fun LearnTogetherTitle(title: String, modifier: Modifier = Modifier,): Unit {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
    }

    @Composable
    fun LearnTogetherFirstParagraph(text: String, modifier: Modifier){
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
        )
    }

    @Composable
    fun LearnTogetherLastParagraph(text: String, modifier: Modifier){
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp),
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PagePreview(modifier: Modifier = Modifier) {
        LearnTogetherTheme {
            Page("Jetpack Compose tutorial", "Jetpack Compose is a modern toolkit for building native Android UI. " +
                    "Compose simplifies and accelerates UI development on " +
                    "Android with less code, powerful tools, and intuitive Kotlin APIs", "In this tutorial, you build a simple UI component with declarative functions. " +
                    "You call Compose functions to say what elements you want and the Compose compiler does the rest. " +
                    "Compose is built around Composable functions. " +
                    "These functions let you define your app\\'s UI programmatically because they " +
                    "let you describe how it should look and provide data dependencies, " +
                    "rather than focus on the process of the UI\\'s construction, such as " +
                    "initializing an element and then attaching it to a parent. " +
                    "To create a Composable function, you add the @Composable annotation " +
                    "to the function name.", modifier)
        }
    }
}