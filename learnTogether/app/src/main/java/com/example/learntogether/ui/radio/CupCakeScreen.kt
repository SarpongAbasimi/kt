package com.example.learntogether.ui.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learntogether.data.CupCakeDataSource
import com.example.learntogether.model.CupCakeRoute
import com.example.learntogether.ui.theme.LearnTogetherTheme


@Composable
fun CupCakeScreen(
    navController: NavHostController =  rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = CupCakeRoute.StartOrderScreenRoute.name
    ) {
        composable(CupCakeRoute.StartOrderScreenRoute.name){
            StartOrderScreen(
                data = CupCakeDataSource.cupCakeQuantityOptions,
                {
                    navController.navigate(CupCakeRoute.SelectFlavourScreen.name)
                }
            )
        }
        composable(CupCakeRoute.SelectFlavourScreen.name){
            SelectOptionScreen(CupCakeDataSource.cupCakeFlavourOptions)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CupCakeScreenPreview(){
    LearnTogetherTheme {
        CupCakeScreen()
    }
}