package com.example.proyectoandroidv2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.presentation.ui.screens.addProduct.AñadirProducto
import com.example.proyectoandroidv2.presentation.ui.screens.listProducts.ListOfProducts
import com.example.proyectoandroidv2.presentation.ui.screens.login.LoginScreen
import com.example.proyectoandroidv2.presentation.ui.screens.modifyProduct.ModificarProducto
import com.example.proyectoandroidv2.presentation.viewmodel.products.ProductViewModel
import com.example.proyectoandroidv2.presentation.viewmodel.products.ProductsViewModel

sealed class Screen(val route: String) {
    data object Add : Screen("Add")
    data object Modify : Screen("Modify")
    data object Login : Screen("Login")
    data object List : Screen("List")
}

@Composable
fun NavGraph(startDestination: String = Screen.Login.route) {
    val navController = rememberNavController()

    val productsViewModel: ProductsViewModel = viewModel()
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Add.route) {
            AñadirProducto(navController, productViewModel)
        }

        composable(Screen.Modify.route) {
            ModificarProducto(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.List.route) {
            ListOfProducts(navController, productsViewModel)
        }
    }
}

