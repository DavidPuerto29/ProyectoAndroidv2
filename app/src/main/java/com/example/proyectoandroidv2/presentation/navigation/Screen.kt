package com.example.proyectoandroidv2.presentation.navigation

sealed class Screen(val route: String){
    data object Add : Screen("list/add")

    data object Update : Screen("list/update/{id}") {
        fun createRoute(id: String): String = "list/update/$id"
    }

    data object Login : Screen("login")
    data object List : Screen("list")
}