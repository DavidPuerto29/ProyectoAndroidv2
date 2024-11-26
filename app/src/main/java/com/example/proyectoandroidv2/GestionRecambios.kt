package com.example.proyectoandroidv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectoandroidv2.presentation.ui.screens.addProduct.AñadirProducto
import com.example.proyectoandroidv2.presentation.ui.screens.login.loginScreen
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme

class GestionRecambios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAndroidv2Theme {
                //loginScreen()
                AñadirProducto()
            }
        }
    }
}

@Composable
fun Vista() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProyectoAndroidv2Theme {

    }
}