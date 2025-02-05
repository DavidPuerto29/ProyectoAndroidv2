package com.example.proyectoandroidv2.domain.usecase

import com.example.proyectoandroidv2.data.repository.source.remote.ProductRepository
import com.example.proyectoandroidv2.domain.model.Product

class UpdateProductsUseCase(private val productRepository: ProductRepository) {
    operator suspend fun invoke(product: Product): Unit {
        productRepository.update(product)
    }
}