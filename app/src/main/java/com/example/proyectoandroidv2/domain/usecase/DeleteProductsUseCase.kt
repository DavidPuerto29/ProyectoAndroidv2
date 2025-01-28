package com.example.proyectoandroidv2.domain.usecase

import com.example.proyectoandroidv2.data.repository.source.remote.ProductRepository

class DeleteProductsUseCase(
    private val productRepository: ProductRepository
) {
    operator suspend fun invoke(id: String): Unit {
        productRepository.deleteProduct(id)
    }
}