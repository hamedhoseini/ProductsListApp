package com.mihahoni.productslistapp.di

import com.mihahoni.productslistapp.data.repository.ProductsRepository
import com.mihahoni.productslistapp.domain.ProductsUseCase
import com.mihahoni.productslistapp.domain.ProductsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsUseCaseModule {

    @Singleton
    @Provides
    fun productsUseCaseRepository(
        productsRepository: ProductsRepository
    ): ProductsUseCase {
        return ProductsUseCaseImpl(productsRepository)
    }
}