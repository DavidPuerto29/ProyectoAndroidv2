package com.example.proyectoandroidv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme

class GestionRecambios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAndroidv2Theme {
                Vista()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProyectoAndroidv2Theme {
        Vista()
    }
}

@Composable
fun Vista() {
    var nombre by remember { mutableStateOf("") }
    var nReferencia by remember{ mutableStateOf("") }
    var stock by remember { mutableStateOf(0) }
    var fabricante by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf(0) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column {
            Text(text = "-Añadir recambio")
            Row {
                Text(text = "Nombre:")
                TextField(
                    value = nombre,
                    onValueChange = { newText -> nombre = newText }
                )
            }

            Row {
                Text(text = "Numero de referencia:")
                TextField(
                    value = nReferencia,
                    onValueChange = { newText -> nReferencia = newText }
                )
            }
            Row {
                Text(text = "Stock:")
                TextField(
                    value = stock.toString(),
                    onValueChange = { newText -> stock = newText.toIntOrNull() ?: stock}
                )
            }
            Row {
                Text(text = "Fabricante:")
                TextField(
                    value = fabricante,
                    onValueChange = { newText -> fabricante = newText }
                )
            }
            Row {
                Text(text = "Precio:")
                TextField(
                    value = precio.toString(),
                    onValueChange = { newText -> precio = newText.toIntOrNull() ?: stock}
                )
            }
            Button(onClick = { }) {
                Text("Añadir Producto")
            }
        }
    }
}