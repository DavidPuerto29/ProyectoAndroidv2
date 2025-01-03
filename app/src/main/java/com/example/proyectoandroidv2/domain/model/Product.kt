package com.example.proyectoandroidv2.domain.model

data class Product(val id : Int,
    val nombre: String, val numReferencia: String, val stock: Int,
    val fabricante: String, val material: String, val garantia: String, val precio: Double)
