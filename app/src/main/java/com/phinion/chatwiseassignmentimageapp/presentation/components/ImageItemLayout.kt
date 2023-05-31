package com.phinion.chatwiseassignmentimageapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.phinion.chatwiseassignmentimageapp.models.ImageItem

@Composable
fun ImageItemLayout(
    imageItem: ImageItem
) {

    Card(
        modifier = Modifier.padding(all = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        shape = RoundedCornerShape(
            size = 8.dp
        )
    ) {

        AsyncImage(
            model = imageItem.url,
            contentDescription = imageItem.title,
            contentScale = ContentScale.Crop
        )

    }

}