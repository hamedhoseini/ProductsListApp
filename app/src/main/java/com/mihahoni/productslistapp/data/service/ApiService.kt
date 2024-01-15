package com.mihahoni.productslistapp.data.service

import com.mihahoni.productslistapp.data.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getAllProducts(): List<Product>

}