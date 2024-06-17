package com.example.moviedb.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.moviedb.model.HomeScreenState
import com.example.moviedb.model.Loading
import com.example.moviedb.model.PopularMovies
import com.example.moviedb.model.ScreenState
import com.example.moviedb.model.Success
import com.example.moviedb.ui.theme.MoviedbTheme
import com.example.moviedb.ui.theme.PurpleGrey80
import com.example.moviedb.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel= viewModel(factory = HomeViewModel.Factory),
    handleDetailNavigation: () -> Unit = {}
){
    val state: ScreenState by  homeViewModel.state.collectAsState()
    val coroutine: CoroutineScope = rememberCoroutineScope()

    StateHandler(state, coroutine, homeViewModel, handleDetailNavigation)
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuccessHandler(
    homeScreenState: HomeScreenState,
    coroutine: CoroutineScope,
    homeViewModel: HomeViewModel,
    handleDetailNavigation: () -> Unit,
    modifier: Modifier = Modifier
) {

    val pagerState: PagerState = rememberPagerState(pageCount = {
       homeScreenState.popularMoviesSize
    })

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.scrim)
    ) {
        HorizontalPagerSample(
            homeScreenState.pagerMovies,
            homeScreenState.popularMoviesSize,
            pagerState,
            Modifier.weight(2f)
        )

        RowMoviesDisplay(
            homeScreenState.popularMovies,
            "Most Popular",
            coroutine,
            pagerState,
            handleDetailNavigation,
            Modifier.weight(1f)
        )

        RowMoviesDisplay(
            homeScreenState.topRatedMovies,
            "Top Rated",
            coroutine,
            pagerState,
            handleDetailNavigation,
            Modifier.weight(1f)
        )

        RowMoviesDisplay(
            homeScreenState.upComing,
            "Discover",
            coroutine,
            pagerState,
            handleDetailNavigation,
            Modifier.weight(1f)
        )

        RowMoviesDisplay(
            homeScreenState.nowPlaying,
            "Now Playing",
            coroutine,
            pagerState,
            handleDetailNavigation,
            Modifier.weight(1f)
        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerSample(
    popularMovies: PopularMovies,
    popularMoviesSize: Int,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(bottom = 5.dp)
    ) {
        Box {
            HorizontalPager(state = pagerState) { page ->
                AsyncImage(
                    model = Util.ImageRequest("${popularMovies.results[page].backdropPath}"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(popularMoviesSize){
                    val color = if (pagerState.currentPage == it) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(10.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowMoviesDisplay(
    popularMovies: PopularMovies,
    title: String,
    coroutine: CoroutineScope,
    pagerState: PagerState,
    handleDetailNavigation: () -> Unit,
    modifier: Modifier = Modifier,
){
   Column(modifier.fillMaxSize()) {
       Text(
           text = title,
           fontWeight = FontWeight.Bold,
           fontFamily = FontFamily.SansSerif,
           fontSize = 20.sp ,
           modifier = Modifier,
           color = PurpleGrey80
       )

       Row(
           Modifier
               .fillMaxWidth()
               .padding(top = 5.dp)
               .horizontalScroll(rememberScrollState())
       ) {

           popularMovies.results.forEachIndexed { index, movieResult ->
               Card(
                   Modifier
                       .padding(start = 1.dp, end = 5.dp)
                       .aspectRatio(0.5f)
                       .clickable {
                           coroutine.launch {
                               pagerState.animateScrollToPage(index)
                               handleDetailNavigation()
                           }
                       }
                   ,
                   colors = CardDefaults.elevatedCardColors(
                       containerColor = Color.Unspecified
                   ),
                   shape = CardDefaults.outlinedShape
               ) {
                   AsyncImage(
                       model = Util.ImageRequest(movieResult.posterPath),
                       contentDescription = null,
                       contentScale = ContentScale.Crop,
                       modifier = Modifier.fillMaxSize()
                   )
               }
           }
       }
   }
}


@Composable
fun StateHandler(
    state: ScreenState,
    coroutine: CoroutineScope,
    homeViewModel: HomeViewModel,
    handleDetailNavigation: () -> Unit
){
    when(state){
        is Loading -> Icon(
            painter = painterResource(id = R.drawable.progess),
            contentDescription = null
        )
        is Success -> SuccessHandler(
            state.homeScreenState,
            coroutine,
            homeViewModel,
            handleDetailNavigation
        )
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