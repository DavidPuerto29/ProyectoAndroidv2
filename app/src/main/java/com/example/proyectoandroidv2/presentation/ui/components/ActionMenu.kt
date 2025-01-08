package com.example.proyectoandroidv2.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.proyectoandroidv2.presentation.navigation.Screen

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MenuDeAcciones(navController: NavController){
    var expanded by remember { mutableStateOf(false) }

    // Barra de herramientas (TopAppBar)
    TopAppBar(
        title = { Text("Listado de productos") },
        actions = {
            // Botón de menú
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Menú"
            )
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menú"
                )
            }

            // Menú desplegable
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Listado") },
                    onClick = {
                        // Acción 1
                        expanded = false
                        navController.navigate(Screen.List.route)
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Añadir")
                    },
                    onClick = {
                        navController.navigate(Screen.Add.route)
                    }
                )
                // Línea divisoria entre elementos
                Divider()
                DropdownMenuItem(
                    text = {
                        Text("Logout")
                    },
                    onClick = {
                        navController.navigate(Screen.Login.route)
                    }
                )
            }
        }
    )
}