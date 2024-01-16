package com.mihahoni.productslistapp.ui.product.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihahoni.productslistapp.data.StateHandler
import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.domain.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
) : ViewModel() {

    private val _productsFetchingState = MutableStateFlow<StateHandler>(StateHandler.Loading)
    val productsFetchingState by lazy { _productsFetchingState }

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _productsList = MutableStateFlow(emptyList<Product>())
    val productsList = searchText
        .combine(_productsList) { text, productsList ->
            if (text.isBlank()) {
                _productsList.asStateFlow()
            }
            productsList.filter { product ->
                product.title.uppercase().contains(text.trim().uppercase())
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000),
            initialValue = _productsList.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    init {
        loadData()
    }

    fun loadData() {
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