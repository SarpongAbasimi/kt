package com.example.moviedb.ui.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviedb.R
import com.example.moviedb.model.DetailsSuccess
import com.example.moviedb.model.Error
import com.example.moviedb.model.Genre
import com.example.moviedb.model.Loading
import com.example.moviedb.model.MovieDetails
import com.example.moviedb.model.ScreenState
import com.example.moviedb.ui.theme.MoviedbTheme
import com.example.moviedb.ui.theme.PurpleGrey80
import com.example.moviedb.util.Util
import kotlinx.coroutines.CoroutineScope

@Composable
fun DetailsScreen(
    navigate: () -> Unit = {},
    viewModel: DetailViewModel = viewModel(factory = DetailViewModel.Factory)
){
    val state: ScreenState by viewModel.uiState.collectAsState()
    val coroutine: CoroutineScope = rememberCoroutineScope()
    StateHandler(state, coroutine,viewModel, navigate)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailSuccessHandler(
    detailScreenState: MovieDetails,
    coroutine: CoroutineScope,
    detailViewModel: DetailViewModel,
    navigate: () -> Unit
) {
    Box(modifier = Modifier){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.scrim)
        ) {
            PosterHandler(imageUrl =  detailScreenState.backdropPath, modifier = Modifier)
            TitleWithData(detailScreenState.originalTitle, detailScreenState.genres, modifier = Modifier)
            OverView(detailScreenState.overview)
            PosterContent(detailScreenState.posterPath, modifier = Modifier.weight(1f))
        }   
        
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.clickable(onClick = navigate)
        )
    }
}

@Composable
fun PosterHandler(
    imageUrl: String,
    modifier: Modifier
){
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = modifier.padding(bottom = 8.dp)
    ) {
        Util.ImageRequest(imageUrl)
    }
}

@Composable
fun TitleWithData(title: String, genre: List<Genre>, modifier: Modifier){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

        Row {
            genre.forEach{ genre ->
                Text(
                text = genre.name,
                color = PurpleGrey80 ,
                fontFamily =  FontFamily.SansSerif,
                modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}

@Composable
fun OverView(content: String){
    Card(colors = CardDefaults.elevatedCardColors(
        containerColor = MaterialTheme.colorScheme.scrim
    ), modifier = Modifier.padding(0.dp)) {
        Text(text = content,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(5.dp),
            color = Color.White,
            fontFamily =  FontFamily.SansSerif
        )
    }
}

@Composable
fun PosterContent(posterPath: String = "/kDp1vUBnMpe8ak4rjgl3cLELqjU.jpg", modifier: Modifier = Modifier){
    Row {
        Card(modifier = modifier) {
            Util.ImageRequest(posterPath)
        }
    }
}



@Composable
fun StateHandler(
    state: ScreenState,
    coroutine: CoroutineScope,
    detailViewModel: DetailViewModel,
    navigate: () -> Unit,
){
    when(state){
        is Loading -> Icon(
            painter = painterResource(id = R.drawable.progess),
            contentDescription = null
        )
        is DetailsSuccess -> DetailSuccessHandler(
            state.detailsScreenState,
            coroutine,
            detailViewModel,
            navigate
        )

        is Error -> Icon(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = null
        )
        else -> Icon(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = null
        )
    }
}

@Preview()
@Composable
fun DetailsScreenPreview(){
    MoviedbTheme {
        DetailsScreen()
    }
}