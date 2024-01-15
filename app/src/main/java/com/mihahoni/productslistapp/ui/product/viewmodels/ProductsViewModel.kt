package com.mihahoni.productslistapp.ui.product.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihahoni.productslistapp.data.StateHandler
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

    private val _productsFetchingState = MutableStateFlow<StateHandler>(StateHandler.Loading)
    val productsFetchingState by lazy { _productsFetchingState }


    private val _productsList = MutableStateFlow(emptyList<Product>())
    val productsList by lazy { _productsList.asStateFlow() }

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                val productListFromApi = productsUseCase.getProducts()
                _productsList.value = productListFromApi
                _productsFetchingState.value = StateHandler.Success(productListFromApi)

            } catch (exception: Exception) {
                _productsFetchingState.value = StateHandler.Failure(exception.message)
            }
        }
    }
}