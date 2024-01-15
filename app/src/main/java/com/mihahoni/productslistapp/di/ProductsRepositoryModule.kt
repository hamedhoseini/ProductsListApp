package com.mihahoni.productslistapp.di

import com.mihahoni.productslistapp.data.repository.ProductsRepository
import com.mihahoni.productslistapp.data.repository.ProductsRepositoryImpl
import com.mihahoni.productslistapp.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsRepositoryModule {

    @Singleton
    @Provides
    fun provideProductsRepository(
        apiService: ApiService
    ): ProductsRepository {
        return ProductsRepositoryImpl(apiService)
    }
}