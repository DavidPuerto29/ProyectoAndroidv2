package com.example.proyectoandroidv2.di

import com.example.proyectoandroidv2.data.repository.source.remote.ProductRepository
import com.example.proyectoandroidv2.domain.usecase.AddProductsUseCase
import com.example.proyectoandroidv2.domain.usecase.DeleteProductsUseCase
import com.example.proyectoandroidv2.domain.usecase.GetProductUseCase
import com.example.proyectoandroidv2.domain.usecase.ListProductsUseCase
import com.example.proyectoandroidv2.domain.usecase.UpdateProductsUseCase
import com.example.proyectoandroidv2.presentation.viewmodel.modificar.UpdateViewModel
import com.example.proyectoandroidv2.presentation.viewmodel.products.AddProductViewModel
import com.example.proyectoandroidv2.presentation.viewmodel.products.ProductsViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
//--------------------------------------------------------------------------------
    single { FirebaseFirestore.getInstance() }
    single { ProductRepository(get()) }
//--------------------------------------------------------------------------------
    factory { AddProductsUseCase(get()) }
    factory { UpdateProductsUseCase(get()) }
    factory { ListProductsUseCase(get()) }
    factory { GetProductUseCase(get()) }
    factory { DeleteProductsUseCase(get()) }

//--------------------------------------------------------------------------------
    viewModel { UpdateViewModel(get(), get()) }
    viewModel { ProductsViewModel(get(), get()) }
    viewModel { AddProductViewModel(get()) }
//--------------------------------------------------------------------------------
}