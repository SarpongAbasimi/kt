package com.example.todo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.model.AddTodo
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
    val add: String = navRoutes.build(AddTodo)

    NavHost(navController = navController, startDestination = navRoutes.build(Todos)) {
        composable(todos){
            TodoScreen({navController.navigate(add)}, {navController.navigate(edit)})
        }

        composable(add){
            FormScreen({navController.popBackStack()})
        }

        composable(edit){
            EditScreen()
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

