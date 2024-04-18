package com.example.businesscard.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.R

class BCard {

    @Composable
    fun Create(){
        Column(modifier = Modifier
            .fillMaxSize(),
        ) {
            Info(
                name = "Jennifer Doe",
                title = "Andriod Developer Extraordinaire",
                modifier = Modifier.weight(3f),
                backgroundColor = Color.DarkGray
            )

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContactDetails(
                    "contact",
                    "+11(123) 444 555 666",
                    R.drawable.android_logo,
                    Modifier
                )
                ContactDetails(
                    "profile",
                    "AndriodDev",
                    R.drawable.android_logo,
                    Modifier
                )
                ContactDetails(
                    "email",
                    "jen.doe@andriod.com",
                    R.drawable.android_logo,
                    Modifier
                )
            }
        }
    }

    @Composable
    fun Info(name: String, title: String, modifier: Modifier, backgroundColor: Color){
        Column(
            modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(
                id =  R.drawable.android_logo),
                contentDescription =  null,
                modifier = Modifier
                    .background(backgroundColor)
                    .size(200.dp)
                ,
            )
            Text(
                text = name,
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 40.sp
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }

    @Composable
    fun ContactDetails(
        description: String?,
        text: String,
        imageResource: Int,
        modifier: Modifier
    ) {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = imageResource) ,
                    contentDescription = description,
                    modifier =  modifier
                        .size(20.dp)

                        .weight(1f),
                    alignment = Alignment.TopEnd
                )
                Text(
                    text = text,
                    modifier =  modifier

                        .padding(start = 5.dp)
                        .weight(2f)
                )

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ThePreview(modifier: Modifier = Modifier){
        Create()
    }
}