package com.example.learntogether.ui.radio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learntogether.data.CupCakeDataSource
import com.example.learntogether.model.CupCakeRoute
import com.example.learntogether.ui.theme.LearnTogetherTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learntogether.R

@Composable
fun CupCakeScreen(
    viewModel: CupCakeViewModel = viewModel(),
    navController: NavHostController =  rememberNavController()
){
    val state by viewModel.state.collectAsState()

    NavHost(
        navController = navController,
        startDestination = CupCakeRoute.StartOrderScreenRoute.name
    ) {
        composable(CupCakeRoute.StartOrderScreenRoute.name){
            StartOrderScreen(
                data = CupCakeDataSource.cupCakeQuantityOptions,
                { input ->
                    viewModel.updateQuantity(input)
                    navController.navigate(CupCakeRoute.SelectFlavourScreen.name)
                }
            )
        }
        composable(CupCakeRoute.SelectFlavourScreen.name){
            SelectOptionScreen(
                CupCakeDataSource.cupCakeFlavourOptions,
                subtotal = state.price.toString(),
                onClickCancel = {
                    handleOnclickCancel(navController)
                },
                onClickNext = { input -> viewModel.updateFlavour(input) },
                title = R.string.chose_flavor
            )
        }
    }
}

fun handleOnclickCancel(navController: NavController){
    navController.popBackStack(CupCakeRoute.StartOrderScreenRoute.name, false)
}



@Preview(showBackground = true)
@Composable
fun CupCakeScreenPreview(){
    LearnTogetherTheme {
        CupCakeScreen()
    }
}