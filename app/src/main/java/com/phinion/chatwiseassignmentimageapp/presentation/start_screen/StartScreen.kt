package com.phinion.chatwiseassignmentimageapp.presentation.start_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.phinion.chatwiseassignmentimageapp.ui.theme.poppins_medium
import com.phinion.chatwiseassignmentimageapp.util.Screen

@Composable
fun StartScreen(
    navController: NavController
) {

    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(colors.primary)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "Assignment Project By Priyanshu",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins_medium
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {

                navController.navigate(Screen.ImageListScreen.route)

            }, modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(50.dp),
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
        ) {
            Text(
                text = "Show Images",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins_medium
                )
            )
        }

    }
}