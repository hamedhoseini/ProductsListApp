package com.mihahoni.productslistapp

import com.mihahoni.productslistapp.domain.ProductsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ProductsUseCaseTest {

    @Test
    fun `getProducts should return a list of products`() {
        val productsUseCase = mock(ProductsUseCase::class.java)
        `when`(runBlocking { productsUseCase.getProducts() }).thenReturn(fakeProductList)

        val result = runBlocking { productsUseCase.getProducts() }

        assertEquals(fakeProductList, result)
    }

    @Test(expected = Exception::class)
    fun `getProducts should throw an exception on failure`() {
        val errorMessage = "Network error"
        val productsUseCase = mock(ProductsUseCase::class.java)
        `when`(runBlocking { productsUseCase.getProducts() }).thenThrow(RuntimeException(errorMessage))

        runBlocking { productsUseCase.getProducts() }
    }
}
