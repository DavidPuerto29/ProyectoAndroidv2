package com.example.proyectoandroidv2.presentation.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoandroidv2.presentation.navigation.Screen
import com.example.proyectoandroidv2.presentation.viewmodel.login.UsernamePasswordViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.ColorFilter
import com.example.proyectoandroidv2.R

@Composable
fun LoginScreen(
    navController: NavController,
    usernamePasswordViewModel: UsernamePasswordViewModel = viewModel()
    ) {
    val username by usernamePasswordViewModel.username.collectAsState()
    val password by usernamePasswordViewModel.password.collectAsState()
    var passwordVisible by remember { mutableStateOf(false) }

    val condicion = username.isNotEmpty() && password.length >= 4

    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()) {
        Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier.size(200.dp).padding(10.dp),
                contentScale = ContentScale.Crop,
            )
            TextField(value = username, onValueChange = { usernamePasswordViewModel.setUsername(it) }, placeholder = { Text("Usuario:")}, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            TextField(value = password, onValueChange = { usernamePasswordViewModel.setPassword(it) },
                placeholder = { Text("Contraseña:")}, visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),

                trailingIcon = {
                    val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row{
                Button(onClick = { if(usernamePasswordViewModel.isValidLogin()) navController.navigate(Screen.List.route)} , enabled = condicion, modifier = Modifier.padding(5.dp)) { Text("   Login  ")
                }

                Button(onClick = { usernamePasswordViewModel.clear() }, modifier = Modifier.padding(5.dp)) {
                    Text("Reiniciar")
                }
            }
        }
    }
}

