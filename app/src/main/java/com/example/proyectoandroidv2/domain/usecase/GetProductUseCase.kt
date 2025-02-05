package com.example.proyectoandroidv2.domain.usecase

import com.example.proyectoandroidv2.data.repository.source.remote.ProductRepository
import com.example.proyectoandroidv2.domain.model.Product

class GetProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: String?): Product? {
        return productRepository.getProductById(productId)
    }
}