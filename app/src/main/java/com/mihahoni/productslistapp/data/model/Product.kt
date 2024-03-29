package com.mihahoni.productslistapp.data.model


data class Product(
    val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: ProductRating
)

