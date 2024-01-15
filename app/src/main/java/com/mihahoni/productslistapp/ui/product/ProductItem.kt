package com.mihahoni.productslistapp.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mihahoni.productslistapp.R
import com.mihahoni.productslistapp.ui.theme.Gray
import com.mihahoni.productslistapp.ui.theme.Red

@Preview
@Composable
fun ProductItem() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxHeight(), contentScale = ContentScale.FillHeight,
                painter = painterResource(R.drawable.test_image),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceAround,
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Pullover", style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = "Category",
                        Modifier
                            .padding(4.dp)
                            .background(color = Red)
                            .padding(4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,

                        )
                }
                Text(text = "mango", style = MaterialTheme.typography.labelSmall, color = Gray)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StarRatingBar(rating = 3F, maxStars = 5)
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "(3)",
                        color = Gray,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
                Text(text = "51$", style = MaterialTheme.typography.titleMedium)

            }

        }
    }

}