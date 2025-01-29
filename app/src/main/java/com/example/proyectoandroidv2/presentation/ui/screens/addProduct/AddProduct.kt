package com.example.proyectoandroidv2.presentation.ui.screens.addProduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.presentation.navigation.Screen
import com.example.proyectoandroidv2.presentation.viewmodel.products.AddProductViewModel
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AñadirProducto(navController: NavController,
                   addProductViewModel: AddProductViewModel) {
    val product by addProductViewModel.product.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding() ,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Añadir recambio")

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.nombre,
                    onValueChange = { addProductViewModel.setNombre(it) }
                    , placeholder = { Text("Nombre:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.numReferencia,
                    onValueChange = { addProductViewModel.setNumReferencia(it) }
                    , placeholder = { Text("Numero de referencia:")}
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.stock.toString(),
                    onValueChange = { newStock -> newStock.toIntOrNull()?.let { addProductViewModel.setStock(it)}}
                    , placeholder = { Text("Stock:")} //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.fabricante,
                    onValueChange = { addProductViewModel.setFabricante(it)}
                    , placeholder = { Text("Fabricante:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.material,
                    onValueChange = { addProductViewModel.setMaterial(it) }
                    , placeholder = { Text("Material:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.garantia,
                    onValueChange = { addProductViewModel.setGarantia(it) }
                    , placeholder = { Text("Garantía:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.precio.toString(),
                    onValueChange = { newPrecio -> newPrecio.toDoubleOrNull()?.let { addProductViewModel.setPrecio(it)}
                    }
                    , placeholder = { Text("Precio:")} //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row{
                Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
                    Text("Añadir Producto")
                }

                Button(onClick = {navController.navigate(Screen.List.route)}, modifier = Modifier.padding(5.dp)) {
                    Text("Cancelar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidv2Theme {
        AñadirProducto(navController = rememberNavController(), viewModel())
    }
}