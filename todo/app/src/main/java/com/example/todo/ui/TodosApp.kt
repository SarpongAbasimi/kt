package com.example.todo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todo.model.Add
import com.example.todo.model.Edit
import com.example.todo.model.Todos
import com.example.todo.navigation.NavRoutes
import com.example.todo.navigation.NavigationService
import com.example.todo.ui.edit.EditScreen
import com.example.todo.ui.form.FormScreen
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.ui.todos.TodoScreen


@Composable
fun TodosApp(navRoutes: NavRoutes, navController: NavHostController){
    val edit: String = navRoutes.build(Edit)
    val todos: String = navRoutes.build(Todos)
    val add: String = navRoutes.build(Add)

    NavHost(navController = navController, startDestination = navRoutes.build(Todos)) {
        composable(todos){ backStackEntry: NavBackStackEntry ->
            TodoScreen({
                navController.navigate(add)},
                {navController.navigate("$edit/$it")}
            )
        }

        composable(add){
            FormScreen({navController.popBackStack()})
        }

        composable(route = "$edit/{id}",
            arguments = listOf(navArgument("id", builder = { NavType.IntType }))
        ){
            EditScreen({ navController.popBackStack() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodosAppPreview(){
    val navController: NavHostController = rememberNavController()
    val routes: NavigationService = NavigationService()
    TodoTheme {
        TodosApp(navRoutes = routes, navController = navController)
    }
}

