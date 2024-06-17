package com.example.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviedb.model.Detail
import com.example.moviedb.model.Home
import com.example.moviedb.ui.detail.DetailsScreen
import com.example.moviedb.ui.home.HomeScreen
import com.example.moviedb.ui.theme.MoviedbTheme

@Composable
fun NavHandler(navController: NavHostController = rememberNavController()){
    val homeRoute = Home.name()
    val detailRoute = Detail.name()

    NavHost(navController = navController, startDestination = homeRoute){
        composable(homeRoute, arguments = listOf(navArgument("id", { type = NavType.IntType })))
        {
            HomeScreen(
                handleDetailNavigation = {
                    navController.navigate("$detailRoute/$it")
                }
            )
        }

        composable("$detailRoute/{id}"){navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            DetailsScreen(id)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavControllerPreview(){
    MoviedbTheme {
        NavHandler()
    }
}