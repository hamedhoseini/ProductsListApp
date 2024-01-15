package com.mihahoni.productslistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mihahoni.productslistapp.ui.product.ProductsPage
import com.mihahoni.productslistapp.ui.theme.ProductsListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsListAppTheme {
                ProductsPage()
            }
        }
    }
}