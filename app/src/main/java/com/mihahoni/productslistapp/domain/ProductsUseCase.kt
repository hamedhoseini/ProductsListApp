package com.mihahoni.productslistapp.domain

import com.mihahoni.productslistapp.data.model.Product

interface ProductsUseCase {
    suspend fun getProducts(): List<Product>
}