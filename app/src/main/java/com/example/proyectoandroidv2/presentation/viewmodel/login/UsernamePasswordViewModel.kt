package com.example.proyectoandroidv2.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UsernamePasswordViewModel : ViewModel() {
    private val USERNAME = "admin"
    private val PASSWORD = "admin"

    private val _username = MutableStateFlow<String>("")
    val username : StateFlow<String> = _username

    private val _password = MutableStateFlow<String>("")
    val password : StateFlow<String> = _password

    fun username(username : String){
        this._username.value = username
    }

    fun password(password : String){
        this._password.value = password
    }

    fun clear(){
        this._username.value = ""
        this._password.value = ""
    }

    fun isValidLogin(): Boolean = this.username.value == USERNAME && this.password.value == PASSWORD
}