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

    fun setUsername(username : String){
        this._username.value = username
    }

    fun setPassword(password : String){
        this._password.value = password
    }

    fun clear(){
        this._username.value = ""
        this._password.value = ""
    }

<<<<<<< HEAD
    fun isValidLogin(): Boolean {
        return this.username.value == USERNAME && this.password.value == PASSWORD
    }
=======
    fun isValidLogin(): Boolean = this.username.value == USERNAME && this.password.value == PASSWORD
>>>>>>> 00a5ea5a78c6f30321f6c698a7c7c25df2848d8d
}