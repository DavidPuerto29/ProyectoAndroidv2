package com.example.proyectoandroidv2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.presentation.ui.screens.addProduct.AñadirProducto
import com.example.proyectoandroidv2.presentation.ui.screens.listProducts.ListOfProducts
import com.example.proyectoandroidv2.presentation.ui.screens.login.LoginScreen

sealed class Screen(val route: String) {
    data object Home : Screen("Home")
    data object Login : Screen("Login")
    data object List : Screen("List")
}

@Composable
fun NavGraph(startDestination: String = Screen.List.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            AñadirProducto(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.List.route) {
            ListOfProducts(navController)
        }
    }
}

