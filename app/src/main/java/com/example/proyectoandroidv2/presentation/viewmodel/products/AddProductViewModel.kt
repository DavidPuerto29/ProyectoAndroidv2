package com.example.proyectoandroidv2.presentation.viewmodel.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroidv2.domain.model.Product
import com.example.proyectoandroidv2.domain.usecase.AddProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddProductViewModel(val addProductUseCase: AddProductsUseCase): ViewModel(){

    private val _product = MutableStateFlow(
        Product("0","", "",0,"","","",0.00)
    )
    val product: StateFlow<Product> = _product

    fun setNombre(nombre: String) {
        _product.value = _product.value.copy(
            nombre = nombre
        )
    }

    fun setNumReferencia(numReferencia: String) {
        _product.value = _product.value.copy(
            numReferencia = numReferencia
        )
    }

    fun setStock(stock: Int) {
        _product.value = _product.value.copy(
            stock = stock
        )
    }

    fun setFabricante(fabricante: String) {
        _product.value = _product.value.copy(
            fabricante = fabricante
        )
    }

    fun setMaterial(material: String) {
        _product.value = _product.value.copy(
            material = material
        )
    }

    fun setGarantia(garantia: String) {
        _product.value = _product.value.copy(
            garantia = garantia
        )
    }

    fun setPrecio(precio: Double) {
        _product.value = _product.value.copy(
            precio = precio
        )
    }

    fun save() {
        viewModelScope.launch {
            addProductUseCase(product.value)
        }
    }
}