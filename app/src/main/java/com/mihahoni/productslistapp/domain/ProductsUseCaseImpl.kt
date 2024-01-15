package com.mihahoni.productslistapp.domain

import com.mihahoni.productslistapp.data.repository.ProductsRepository

class ProductsUseCaseImpl(private val productsRepository: ProductsRepository) : ProductsUseCase {
}