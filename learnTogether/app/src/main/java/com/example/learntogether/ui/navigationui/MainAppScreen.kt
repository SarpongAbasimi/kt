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
import com.example.learntogether.model.NavUiNav
import com.example.learntogether.ui.theme.LearnTogetherTheme


@Composable
fun MainAppScreen(navController: NavHostController = rememberNavController()){
    NavHost(navController = navController, startDestination = NavUiNav.NavOne.name) {
      composable(route = NavUiNav.NavOne.name){
          NavCard(
              cardData = "This is card One",
              modifier =Modifier.fillMaxSize(),
              onNextClick = { navController.navigate(NavUiNav.NavTwo.name)}
          )
      }
        composable(NavUiNav.NavTwo.name){
            NavCard(
                cardData = "This is card two",
                modifier =Modifier.fillMaxSize().background(Color.Blue),
                onNextClick = { navController.navigate(NavUiNav.NavThree.name)},
                onBackClick = {navController.popBackStack()}
            )
        }
        composable(NavUiNav.NavThree.name){
            NavCard(
                cardData = "This is card three",
                modifier =Modifier.fillMaxSize(),
                onNextClick = { navController.navigate(NavUiNav.NavThree.name)},
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