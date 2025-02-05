package com.example.proyectoandroidv2.presentation.viewmodel.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroidv2.domain.model.Product
import com.example.proyectoandroidv2.domain.usecase.DeleteProductsUseCase
import com.example.proyectoandroidv2.domain.usecase.ListProductsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductsViewModel(
    val listproductsUseCase: ListProductsUseCase,
    val deleteProductUseCase: DeleteProductsUseCase,
)  : ViewModel() {

    private val _products = listproductsUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val products: StateFlow<List<Product>> = _products

    fun removeProduct(id: String) {
        viewModelScope.launch {
            deleteProductUseCase(id)
        }
    }
}