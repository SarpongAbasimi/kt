package com.example.learntogether.ui.marsphotos.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learntogether.R
import com.example.learntogether.clients.HttpClient
import com.example.learntogether.model.BaseUrl
import com.example.learntogether.model.MarsPhoto
import com.example.learntogether.model.RequestStates
import com.example.learntogether.network.MarHttpApi
import com.example.learntogether.ui.marsphotos.viewmodel.MarsViewModel
import com.example.learntogether.ui.theme.LearnTogetherTheme

@Composable
fun MarsAppScreen(marsViewModel: MarsViewModel = viewModel()){
    val state by marsViewModel.state.collectAsState()
    HandleState(state)
}

@Composable
fun HandleState(state: RequestStates){
    when(state) {
        RequestStates.Loading-> StateScreen(
            R.string.loading,
            R.drawable.progress_activity_24dp_fill0_wght400_grad0_opsz24,
            Modifier
        )
        RequestStates.Failure -> StateScreen(
            R.string.check_internet_connection_and_try_again,
            R.drawable.cloud_off_24dp_fill0_wght400_grad0_opsz24,
            Modifier
        )
        is RequestStates.Success -> SuccessResponseScreen(state.result)
    }
}


@Composable
fun SuccessResponseScreen(response: List<MarsPhoto>){
    Text(text = "The result size is ${response.size}")
}


@Composable
fun StateScreen(@StringRes text: Int, @DrawableRes image: Int,  modifier: Modifier,){
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = image) , contentDescription = null )
        Text(text = stringResource(text), Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MarsAppScreenPreview(){
    LearnTogetherTheme {
        val url: String = "https://android-kotlin-fun-mars-server.appspot.com"
        val marsHttpApi: MarHttpApi =  HttpClient.build(BaseUrl(url))
        val viewModel: MarsViewModel = MarsViewModel(marsHttpApi)
        MarsAppScreen(viewModel)
    }
}