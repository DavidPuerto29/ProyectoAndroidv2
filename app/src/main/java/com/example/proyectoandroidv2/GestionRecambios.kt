package com.example.proyectoandroidv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyectoandroidv2.presentation.navigation.NavGraph
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme

class GestionRecambios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAndroidv2Theme {
                NavGraph()
            }
        }
    }
}

