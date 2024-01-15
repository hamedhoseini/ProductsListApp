package com.mihahoni.productslistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.mihahoni.productslistapp.ui.product.ProductsPage
import com.mihahoni.productslistapp.ui.product.viewmodels.ProductsViewModel
import com.mihahoni.productslistapp.ui.theme.ProductsListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsListAppTheme {
                val productViewModel by viewModels<ProductsViewModel>()
                ProductsPage(productViewModel)
            }
        }
    }
}