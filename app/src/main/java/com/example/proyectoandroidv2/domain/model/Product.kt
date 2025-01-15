package com.example.proyectoandroidv2.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Product(@DocumentId val idSql: Int val id : Int,
    val nombre: String, val numReferencia: String, val stock: Int,
    val fabricante: String, val material: String, val garantia: String,
    val precio: Double,@ServerTimestamp val createdAt: Date? = null )
