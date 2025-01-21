package com.example.proyectoandroidv2.presentation.viewmodel.products

import androidx.lifecycle.ViewModel
import com.example.proyectoandroidv2.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel: ViewModel(){

    private val _product = MutableStateFlow(
        Product(0,"", "",0,"","","",0.00)
    )
    val product: StateFlow<Product> = _product

    fun setIdSql(idSql: Int) {
        _product.value = _product.value.copy(
            idSql = idSql
        )
    }

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
        // TODO guardar en la base de datos
        // productoDao.save(_product.value)
    }

}