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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme

@Composable
fun AñadirProducto(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var nReferencia by remember{ mutableStateOf("") }
    var stock by remember { mutableStateOf(0) }
    var fabricante by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf(0.00) }
    var material by remember { mutableStateOf("") }
    var garantia by remember { mutableStateOf("") }
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

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = nombre,
                    onValueChange = { newText -> nombre = newText }
                    , placeholder = { Text("Nombre:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = nReferencia,
                    onValueChange = { newText -> nReferencia = newText }
                    , placeholder = { Text("Numero de referencia:")}
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = stock.toString(),
                    onValueChange = { newText -> stock = newText.toIntOrNull() ?: stock}
                    , placeholder = { Text("Stock:")} //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }
            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = fabricante,
                    onValueChange = { newText -> fabricante = newText }
                    , placeholder = { Text("Fabricante:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = material,
                    onValueChange = { newText -> material = newText}
                    , placeholder = { Text("Material:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = garantia,
                    onValueChange = { newText -> garantia = newText}
                    , placeholder = { Text("Garantía:")}
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                TextField(
                    value = precio.toString(),
                    onValueChange = { newText -> precio =
                        (newText.toDoubleOrNull() ?: stock).toDouble()
                    }
                    , placeholder = { Text("Precio:")} //ARREGLAR
                    ,modifier = Modifier.weight(1f)
                )
            }

            Row{
                Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
                    Text("Añadir Producto")
                }

                Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
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
        AñadirProducto(navController = rememberNavController())
    }
}