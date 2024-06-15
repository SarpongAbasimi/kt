package com.example.moviedb.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.model.Error
import com.example.moviedb.model.Loading
import com.example.moviedb.model.PopularMovies
import com.example.moviedb.model.ScreenState
import com.example.moviedb.model.Success
import com.example.moviedb.ui.theme.MoviedbTheme
import com.example.moviedb.ui.theme.PurpleGrey80
import com.example.moviedb.util.Util


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
        HorizontalPagerSample(popularMovies, Modifier.weight(1f))
        PopularMovies(popularMovies, Modifier.weight(2f))
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
                model = Util.ImageRequest("${popularMovies.results[page].backdropPath}"),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun PopularMovies(popularMovies: PopularMovies, modifier: Modifier = Modifier){
   Column(modifier.fillMaxSize()) {
       Text(
           text = "Most Popular",
           fontWeight = FontWeight.Bold,
           fontFamily = FontFamily.SansSerif,
           fontSize = 35.sp ,
           modifier = Modifier.padding(bottom = 5.dp),
           color = PurpleGrey80
       )

       Row(
           Modifier
               .fillMaxWidth()
               .padding(top = 5.dp)
               .horizontalScroll(rememberScrollState())
       ) {
           popularMovies.results.forEach {
               Card(
                   Modifier
                       .size(100.dp)
                       .padding(start = 1.dp, end = 1.dp),
                   colors = CardDefaults.elevatedCardColors(
                       containerColor = Color.Unspecified
                   ),
                   shape = CardDefaults.outlinedShape
               ) {
                   AsyncImage(
                       model = Util.ImageRequest(it.posterPath),
                       contentDescription = null,
                       modifier.background(Color.Red)
                   )
               }
           }
       }
   }
}


@Composable
fun StateHandler(state: ScreenState){
    when(state){
        is Loading -> Icon(
            painter = painterResource(id = R.drawable.progess),
            contentDescription = null
        )
        is Success -> SuccessHandler(state.result)
        is Error -> Icon(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = null
        )
    }
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    MoviedbTheme {
        HomeScreen()
    }
}