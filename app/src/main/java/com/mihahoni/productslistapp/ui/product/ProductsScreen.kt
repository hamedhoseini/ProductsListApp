package com.mihahoni.productslistapp.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mihahoni.productslistapp.R
import com.mihahoni.productslistapp.data.StateHandler
import com.mihahoni.productslistapp.ui.product.viewmodels.ProductsViewModel
import com.mihahoni.productslistapp.ui.theme.VeryLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsPage(productViewModel: ProductsViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = VeryLightGray) {

        val productList by productViewModel.productsList.collectAsState()
        val productFetchingState = productViewModel.productsFetchingState.collectAsState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = VeryLightGray)
                .padding(16.dp),
        ) {

            SearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = { }, //
                content = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.search_products))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = null
                    )
                },
                colors = SearchBarDefaults.colors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(id = R.string.products),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                style = MaterialTheme.typography.titleLarge
            )

            when (productFetchingState.value) {
                StateHandler.Loading -> {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator()
                    }
                }

                is StateHandler.Success<*> -> {
                    Text(
                        text = String.format(
                            LocalContext.current.getString(R.string._products_found),
                            productList.size
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.labelSmall
                    )

                    ProductsList(productList)
                }

                is StateHandler.Failure -> {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = stringResource(R.string.there_is_no_products),
                            style = MaterialTheme.typography.titleMedium
                        )

                    }
                }
            }

        }
    }
}