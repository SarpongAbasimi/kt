package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val article: Article = Article()
        val taskManager: TaskManager = TaskManager()
        val composeQuadrant = ComposeQuadrant()
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    composeQuadrant.Page(
                        stringResource(R.string.title_one),
                        stringResource(R.string.title_two),
                        stringResource(R.string.title_three),
                        stringResource(R.string.title_four),
                        stringResource(R.string.body_one),
                        stringResource(R.string.body_two),
                        stringResource(R.string.body_three),
                        stringResource(R.string.body_four),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
