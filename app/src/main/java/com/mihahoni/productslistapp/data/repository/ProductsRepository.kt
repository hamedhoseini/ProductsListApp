package com.mihahoni.productslistapp.data.repository

import com.mihahoni.productslistapp.data.model.Product

interface ProductsRepository {
    suspend fun getAllProductFromApi(): List<Product>

}