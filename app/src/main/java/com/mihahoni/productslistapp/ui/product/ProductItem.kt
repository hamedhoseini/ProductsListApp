package com.mihahoni.productslistapp.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.ui.components.StarRatingBar
import com.mihahoni.productslistapp.ui.theme.Gray
import com.mihahoni.productslistapp.ui.theme.Red

@Composable
fun ProductItem(productItem: Product) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                model = productItem.image,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .width(120.dp),
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {

                Text(
                    text = productItem.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StarRatingBar(rating = productItem.rating.rate.toFloat(), maxStars = 5)
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "(${productItem.rating.count})",
                        color = Gray,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${productItem.price} $",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = productItem.category,
                        Modifier
                            .padding(4.dp)
                            .background(color = Red)
                            .padding(4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,

                        )
                }
            }
        }
    }

}