package com.example.proyectoandroidv2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.presentation.ui.screens.addProduct.AñadirProducto
import com.example.proyectoandroidv2.presentation.ui.screens.listProducts.ListOfProducts
import com.example.proyectoandroidv2.presentation.ui.screens.login.LoginScreen
import com.example.proyectoandroidv2.presentation.ui.screens.updateProduct.ModificarProducto
import com.example.proyectoandroidv2.presentation.viewmodel.modificar.UpdateViewModel
import com.example.proyectoandroidv2.presentation.viewmodel.products.AddProductViewModel
import com.example.proyectoandroidv2.presentation.viewmodel.products.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(startDestination: String = Screen.Login.route) {
    val navController = rememberNavController()

    val productsViewModel: ProductsViewModel = koinViewModel()
    val addProductViewModel: AddProductViewModel = koinViewModel()
    val updateViewModel: UpdateViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Add.route) {
            AñadirProducto(navController, addProductViewModel)
        }

        composable(Screen.Update.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            ModificarProducto(navController, id,updateViewModel)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.List.route) {
            ListOfProducts(navController, productsViewModel)
        }
    }
}

