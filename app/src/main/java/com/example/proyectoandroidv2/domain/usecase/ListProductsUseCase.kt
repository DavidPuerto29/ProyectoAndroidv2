package com.example.proyectoandroidv2.domain.usecase

import com.example.proyectoandroidv2.data.repository.source.remote.ProductRepository
import com.example.proyectoandroidv2.domain.model.Product
import kotlinx.coroutines.flow.Flow

class ListProductsUseCase (private val productRepository: ProductRepository){
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.list()
    }
}
