package com.mihahoni.productslistapp.data.repository

import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.data.service.ApiService

class ProductsRepositoryImpl(private val apiService: ApiService) : ProductsRepository {
    override suspend fun getAllProductFromApi(): List<Product> {
        return apiService.getAllProducts()
    }
}