package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        stringResource(R.string.happy_birthday_text),
                        stringResource(R.string.signature_text),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier): Unit {
    val image: Painter = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message,
            from,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun GreetingText(message:String, from: String, modifier: Modifier = Modifier): Unit {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier,
        ) {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview(){
    MyApplicationTheme {
        GreetingText("Happy Birthday Sarpong", "From Ben")
    }
}

@Preview(name = "BirthdayImage")
@Composable
fun GreetingImagePreview() {
    MyApplicationTheme {
        GreetingImage("Happy Birthday Sir", from = "From Andriod")
    }
}