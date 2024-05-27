package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.learntogether.clients.HttpClient
import com.example.learntogether.data.repository.MarsRepositoryService
import com.example.learntogether.model.BaseUrl
import com.example.learntogether.network.MarHttpApi
import com.example.learntogether.ui.counterui.CounterScreen
import com.example.learntogether.ui.marsphotos.screen.MarsAppScreen
import com.example.learntogether.ui.marsphotos.viewmodel.MarsViewModel
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val url: String = "https://android-kotlin-fun-mars-server.appspot.com"
                    val marsHttpApi: MarHttpApi =  HttpClient.build(BaseUrl(url))
                    val marsRepository = MarsRepositoryService(marsHttpApi)
                    val viewModel: MarsViewModel = MarsViewModel(marsRepository)
                    MarsAppScreen(viewModel)
                }
            }
        }
    }
}
