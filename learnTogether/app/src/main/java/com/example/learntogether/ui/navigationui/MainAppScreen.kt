package com.example.learntogether.ui.navigationui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learntogether.ui.theme.LearnTogetherTheme


@Composable
fun MainAppScreen(navController: NavHostController = rememberNavController()){
    NavHost(navController = navController, startDestination = "one") {
      composable(route = "one"){
          NavCard(
              cardData = "This is card One",
              modifier =Modifier.fillMaxSize(),
              onNextClick = { navController.navigate("two")}
          )
      }
        composable("two"){
            NavCard(
                cardData = "This is card two",
                modifier =Modifier.fillMaxSize().background(Color.Blue),
                onNextClick = { navController.navigate("three")},
                onBackClick = {navController.popBackStack()}
            )
        }
        composable("three"){
            NavCard(
                cardData = "This is card three",
                modifier =Modifier.fillMaxSize(),
                onNextClick = { navController.navigate("three")},
                onBackClick = {navController.popBackStack()}
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainAppScreenPreview(){
    LearnTogetherTheme {
        MainAppScreen()
    }
}