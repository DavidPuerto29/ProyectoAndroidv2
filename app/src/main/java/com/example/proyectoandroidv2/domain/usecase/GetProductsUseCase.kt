package com.example.proyectoandroidv2.domain.usecase

import ProductRepository
import com.example.proyectoandroidv2.domain.model.Product
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productRepository: ProductRepository) {
    // Implementamos la lógica del caso de uso dentro de este método
    operator fun invoke(): Flow<List<Product>> {
        // Lógica del caso de uso
        return productRepository.list()
    }
}