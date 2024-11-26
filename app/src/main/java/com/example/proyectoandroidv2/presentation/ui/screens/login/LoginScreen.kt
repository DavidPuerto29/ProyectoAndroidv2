package com.example.proyectoandroidv2.presentation.ui.screens.login

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.proyectoandroidv2.ui.theme.ProyectoAndroidv2Theme

@Composable
fun loginScreen(){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var condicion = username.isNotEmpty() && password.length >= 6

    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()) {
        Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            TextField(value = username, onValueChange = {username = it}, placeholder = { Text("Usuario:")}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            TextField(value = password, onValueChange = {password = it}, placeholder = { Text("Contraseña:")}, modifier = Modifier.fillMaxWidth() )
            Spacer(modifier = Modifier.height(16.dp))
            Row{
                Button(onClick = { } , enabled = condicion, modifier = Modifier.padding(5.dp)) {
                    Text("   Login  ")
                }

                Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
                    Text("Reiniciar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidv2Theme {
        loginScreen()
    }
}