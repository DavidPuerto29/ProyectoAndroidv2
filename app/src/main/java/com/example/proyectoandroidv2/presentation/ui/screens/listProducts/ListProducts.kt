package com.example.proyectoandroidv2.presentation.ui.screens.listProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoandroidv2.domain.model.Product
import com.example.proyectoandroidv2.presentation.navigation.Screen
import com.example.proyectoandroidv2.presentation.ui.components.MenuDeAcciones
import com.example.proyectoandroidv2.presentation.viewmodel.products.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListOfProducts(navController: NavController, productsViewModel: ProductsViewModel = koinViewModel()) {
    val products =  productsViewModel.products.collectAsState().value

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        floatingActionButton = {
            Button(onClick ={ navController.navigate(Screen.Add.route)}) {
                Text("Añadir")
            }
        },
        topBar = {MenuDeAcciones(navController = navController)}
    )
    { paddingValues ->
        LazyColumn(Modifier.padding(paddingValues)) {
            items(products) { product ->
                key(product.idSql) {
                    ProductCard(product, navController, productsViewModel)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product:Product, navController: NavController, productsViewModel: ProductsViewModel) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
        Row {
            if (isSelected) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Contraer",
                    Modifier.clickable { isSelected = false })
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Modificar",
                    Modifier.clickable { navController.navigate(Screen.Update.createRoute(product.idSql))})
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    Modifier.clickable { productsViewModel.removeProduct(product.idSql) })
                Column {
                    Text(text = product.nombre, fontWeight = FontWeight.Bold)
                    Text(text = "Numero de referencia: " + product.numReferencia)
                    Text(text = "Stock: " + product.stock)
                    Text(text = "Fabricante: " + product.fabricante)
                    Text(text = "Material: " + product.material)
                    Text(text = "Garantia: " + product.garantia)
                    Text(text = "Precio: " + product.precio)
                }
            } else {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Desplegar",
                    Modifier.clickable { isSelected = true })
                Text(text = product.nombre)
            }
        }
    }
}
