package com.phinion.chatwiseassignmentimageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.phinion.chatwiseassignmentimageapp.navigation.SetUpNavigation
import com.phinion.chatwiseassignmentimageapp.presentation.image_list_screen.ImageListScreen
import com.phinion.chatwiseassignmentimageapp.ui.theme.ChatWiseAssignmentImageAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatWiseAssignmentImageAppTheme {

                val navController = rememberNavController()

                SetUpNavigation(navController = navController)



            }
        }
    }
}

