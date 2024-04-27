package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.data.AffirmationData
import com.example.learntogether.model.Affirmation
import com.example.learntogether.ui.theme.LearnTogetherTheme

class AffirmationApp {

    @Composable
    fun Create(affirmationData: AffirmationData, modifier:  Modifier){
        LazyColumn(
            modifier = Modifier,
        ) {
            items(affirmationData.loadAffirmation()){data ->
                Card(data, modifier)
            }
        }
    }

    @Composable
    fun Card(affirmation: Affirmation, modifier: Modifier){
        Column(modifier) {
            Image(
                painter = painterResource(id = affirmation.imageResourceId.value), 
                contentDescription =null ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            
            Text(
                text = stringResource(id = affirmation.stringResourceId.value)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview(modifier: Modifier = Modifier){
        val affirmationData = AffirmationData()
        LearnTogetherTheme {
            Create(affirmationData, modifier)
        }
    }
}