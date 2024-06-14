package com.example.moviedb.ui.home

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviedb.R
import com.example.moviedb.model.Loading
import com.example.moviedb.model.Error
import com.example.moviedb.model.PopularMovies
import com.example.moviedb.model.ScreenState
import com.example.moviedb.model.Success
import com.example.moviedb.ui.theme.MoviedbTheme


@Composable
fun HomeScreen(homeViewModel: HomeViewModel= viewModel(factory = HomeViewModel.Factory)){
    val state: ScreenState by  homeViewModel.state.collectAsState()
    StateHandler(state)
}

@Composable
fun SuccessHandler(popularMovies: PopularMovies) {
    Text(text = popularMovies.page.toString() )
}
@Composable
fun StateHandler(state: ScreenState){
    when(state){
        is Loading -> Icon(painter = painterResource(id = R.drawable.progess), contentDescription = null)
        is Success -> SuccessHandler(state.result)
        is Error -> Icon(painter = painterResource(id = R.drawable.warning), contentDescription = null)
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    MoviedbTheme {
        HomeScreen()
    }
}