package com.example.moviedb.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviedb.R
import com.example.moviedb.model.Error
import com.example.moviedb.model.Loading
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
fun SuccessHandler(popularMovies: PopularMovies, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.scrim)
    ) {
        HorizontalPagerSample(popularMovies,
            Modifier.weight(1f)
        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerSample(popularMovies: PopularMovies, modifier: Modifier = Modifier) {
    val pagerState: PagerState = rememberPagerState(pageCount = {
        popularMovies.results.size
    })
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(state = pagerState, Modifier) { page ->
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/original${popularMovies.results[page].backdropPath}")
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
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