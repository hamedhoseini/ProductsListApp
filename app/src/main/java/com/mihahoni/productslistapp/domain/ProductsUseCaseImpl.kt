package com.mihahoni.productslistapp.domain

import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.data.repository.ProductsRepository

class ProductsUseCaseImpl(private val productsRepository: ProductsRepository) : ProductsUseCase {
    override suspend fun getProducts(): List<Product> {
        return productsRepository.getAllProductFromApi()
    }
}