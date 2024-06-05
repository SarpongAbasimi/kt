package com.example.todo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.model.AddTodo
import com.example.todo.model.Navigation
import com.example.todo.model.Todos
import com.example.todo.navigation.NavRoutes
import com.example.todo.navigation.NavigationService
import com.example.todo.ui.form.FormScreen
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.ui.todos.TodoScreen


@Composable
fun TodosApp(navRoutes: NavRoutes, navController: NavHostController){
    NavHost(navController = navController, startDestination = navRoutes.build(Todos)) {
        composable(navRoutes.build(Todos)){
            TodoScreen({navController.navigate(navRoutes.build(AddTodo))})
        }

        composable(navRoutes.build(AddTodo)){
            FormScreen({navController.popBackStack()})
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

