package com.example.learntogether

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.data.DataSource
import com.example.learntogether.model.Topic
import com.example.learntogether.ui.theme.LearnTogetherTheme


class GridDataApp {

    @Composable
    fun Create(dataSource: List<Topic>){
        LazyVerticalGrid(
            GridCells.Adaptive(minSize = 150.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(dataSource){ topic ->
                Card(
                    imageId = topic.imageResourceId,
                    projectTitleId = topic.stringResourceId ,
                    number = topic.number,
                    dotImage = R.drawable.ic_grain,
                    modifier = Modifier
                )
            }
        }
    }

    @Composable
    fun Card(
        imageId: Int,
        projectTitleId:Int,
        number:Int,
        dotImage:Int,
        modifier: Modifier
    ){
        Row(
            modifier
                .height(68.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                Modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = stringResource(id = projectTitleId), Modifier.padding(bottom = 8.dp))
                Row {
                    Image(
                        painter = painterResource(id = dotImage),
                        contentDescription = null,
                        Modifier.padding(end = 8.dp)
                    )
                    Text(text = number.toString())
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPage(){
        LearnTogetherTheme {
            Create(dataSource = DataSource.topics)
        }
    }
}