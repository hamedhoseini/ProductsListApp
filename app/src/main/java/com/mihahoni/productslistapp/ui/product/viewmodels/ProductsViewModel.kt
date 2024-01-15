package com.mihahoni.productslistapp.ui.product.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.domain.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
) : ViewModel() {

    private val _productsList = MutableStateFlow(emptyList<Product>())
    val productsList = _productsList.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        Log.i("#####", "productList.toString()")

        viewModelScope.launch {
            try {
                val productListFromApi = productsUseCase.getProducts()
                _productsList.value = productListFromApi

            } catch (exception: Exception) {
                Log.i("#####22", exception.message.toString())

            }
        }
    }
}