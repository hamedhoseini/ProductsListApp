package com.mihahoni.productslistapp.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mihahoni.productslistapp.R
import com.mihahoni.productslistapp.ui.theme.DarkGray
import com.mihahoni.productslistapp.ui.theme.LightGray
import com.mihahoni.productslistapp.ui.theme.Red
import com.mihahoni.productslistapp.ui.theme.VeryLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProductsPage() {
    Surface(modifier = Modifier.fillMaxSize(), color = VeryLightGray) {
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
            Text(
                text = String.format(
                    LocalContext.current.getString(R.string._products_found), 20
                ),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelSmall
            )

            ProductsList()

        }
    }
}