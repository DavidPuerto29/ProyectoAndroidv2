package com.example.proyectoandroidv2.presentation.viewmodel.listProducts

import androidx.lifecycle.ViewModel
import com.example.proyectoandroidv2.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListProductsViewModel : ViewModel() {
    private var idCounter = 7

    private val _products = MutableStateFlow<List<Product>>(
        listOf(
            Product(1,"Tuerca","1544252A",10,"Tuercas.SL","Aluminio","2 Años",10.00)
            ,Product(2,"Tornillo","564123B",20,"Tornillo.SL","Metal","1 Año",2.00)
            ,Product(3,"Capo","985141635E",15,"Chapa.SL","Aluminio","5 Años",200.00)
            ,Product(4,"Llanta","9874651F",100,"Chapa.SL","Aluminio","5 Años",90.00)
            ,Product(5,"Bloque de motor","8974651U",10,"MotorEngine.SL","MetalForjado","2 Años",1000.00)
            ,Product(6,"Arbol de levas","9874132V",20,"MotorEngine.SL","Aluminio","1 Año",200.00)
        )
    )

    val products: StateFlow<List<Product>> = _products

    fun addTask(id : Int, nombre: String, numReferencia: String, stock: Int, fabricante: String, material: String, garantia: String, precio: Double) {
        val newProduct = Product(id = idCounter, nombre, numReferencia, stock, fabricante, material, garantia, precio)
        _products.value = _products.value + newProduct
        idCounter++
    }

    fun removeTask(id: Int) {
        _products.value = _products.value.filter { it.id != id }
    }
}