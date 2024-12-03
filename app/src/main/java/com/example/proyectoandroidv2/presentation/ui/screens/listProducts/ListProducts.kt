package com.example.proyectoandroidv2.presentation.ui.screens.listProducts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme



@Composable
fun ListOfProducts(navController: NavController) {

    //test
    var nombre = "Producto test"
    var numReferencia = "1653132"
    var stock = 0
    var fabricante = "Manolo"
    var material = "metal"
    var gatantia = "2 años"
    var precio = 200
    //test

    //val itemsList = listOf(

    //)
    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()) {
        LazyColumn {
            //items(itemsList) { item ->

            //}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidv2Theme {
        ListOfProducts(navController = rememberNavController())
    }
}