package com.mihahoni.productslistapp

import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.data.model.ProductRating

 val fakeProductList = listOf(
    Product(
        1,
        "Product 1",
        price = 2.3,
        description = "here my first product description",
        category = "clothing",
        image = "",
        rating = ProductRating(rate = 3.2, count = 32)
    ),
    Product(
        2,
        "Product 2",
        price = 5.3,
        description = "here my second product description",
        category = "electronics",
        image = "",
        rating = ProductRating(rate = 1.2, count = 43)
    )
)