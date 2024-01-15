package com.mihahoni.productslistapp.data.service

import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getAllProducts(): Any

}