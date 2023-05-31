package com.phinion.chatwiseassignmentimageapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phinion.chatwiseassignmentimageapp.ui.theme.poppins_regular

@Composable
fun TopAppBar(
    title: String,
    backButtonOnClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(4.dp))

        IconButton(onClick = {
            backButtonOnClick()
        }) {


            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back button",
                tint = Color.White
            )

        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Images List", style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = poppins_regular
            )
        )

    }


}