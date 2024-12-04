package com.example.proyectoandroidv2.presentation.ui.screens.listProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidv2.domain.model.Product
import com.example.proyectoandroidv2.presentation.navigation.Screen
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme



@Composable
fun ListOfProducts(navController: NavController) {
    val itemsList = listOf(
        Product("Tuerca","1544252A",10,"Tuercas.SL","Aluminio","2 Años",10.00)
        ,Product("Tornillo","564123B",20,"Tornillo.SL","Metal","1 Año",2.00)
        ,Product("Capo","985141635E",15,"Chapa.SL","Aluminio","5 Años",200.00)
        ,Product("Llanta","9874651F",100,"Chapa.SL","Aluminio","5 Años",90.00)
        ,Product("Bloque de motor","8974651U",10,"MotorEngine.SL","MetalForjado","2 Años",1000.00)
        ,Product("Arbol de levas","9874132V",20,"MotorEngine.SL","Aluminio","1 Año",200.00)
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        floatingActionButton = {
            Button(onClick ={ navController.navigate(Screen.Home.route)}) {
                Text("Añadir")
            }
        }

    ) { paddingValues ->
        LazyColumn(Modifier.padding(paddingValues)) {
            items(itemsList) { product ->
                ProductCard(product = product)
            }
        }
    }
}

@Composable
fun ProductCard(product:Product) {
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
                    Modifier.clickable { })
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    Modifier.clickable { })
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidv2Theme {
        ListOfProducts(navController = rememberNavController())
    }
}