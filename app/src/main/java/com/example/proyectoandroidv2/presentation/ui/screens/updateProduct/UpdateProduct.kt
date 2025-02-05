package com.example.proyectoandroidv2.presentation.ui.screens.updateProduct

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoandroidv2.presentation.navigation.Screen
import com.example.proyectoandroidv2.presentation.viewmodel.modificar.UpdateViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ModificarProducto(navController: NavController,productId: String?, updateViewModel: UpdateViewModel = koinViewModel()) {
    val product by updateViewModel.product.collectAsState()
    updateViewModel.setId(productId)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding() ,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Modificar recambio")

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.nombre,
                    onValueChange = { updateViewModel.setNombre(it) }
                    , placeholder = { Text("Nombre:") }
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.numReferencia,
                    onValueChange = { updateViewModel.setNumReferencia(it) }
                    , placeholder = { Text("Numero de referencia:") }
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.stock.toString(),
                    onValueChange = { newStock -> newStock.toIntOrNull()?.let { updateViewModel.setStock(it)}}
                    , placeholder = { Text("Stock:") } //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.fabricante,
                    onValueChange = { updateViewModel.setFabricante(it) }
                    , placeholder = { Text("Fabricante:") }
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.material,
                    onValueChange = { updateViewModel.setMaterial(it) }
                    , placeholder = { Text("Material:") }
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.garantia,
                    onValueChange = { updateViewModel.setGarantia(it) }
                    , placeholder = { Text("Garantía:") }
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = product.precio.toString(),
                    onValueChange = { newPrecio -> newPrecio.toDoubleOrNull()?.let { updateViewModel.setPrecio(it)}
                    }
                    , placeholder = { Text("Precio:") } //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row{
                Button(onClick = { updateViewModel.save()
                                    navController.popBackStack()}, modifier = Modifier.padding(5.dp)) {
                    Text("Modificar Producto")
                }

                Button(onClick = {navController.navigate(Screen.List.route)}, modifier = Modifier.padding(5.dp)) {
                    Text("Cancelar")
                }
            }
        }
    }
}

