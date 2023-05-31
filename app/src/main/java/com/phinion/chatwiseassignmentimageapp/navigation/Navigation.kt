package com.phinion.chatwiseassignmentimageapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phinion.chatwiseassignmentimageapp.presentation.image_list_screen.ImageListScreen
import com.phinion.chatwiseassignmentimageapp.presentation.start_screen.StartScreen
import com.phinion.chatwiseassignmentimageapp.util.Screen

@Composable
fun SetUpNavigation(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.StartScreen.route){

        composable(route = Screen.StartScreen.route){
            StartScreen(navController = navController)
        }
        composable(route = Screen.ImageListScreen.route){
            ImageListScreen(navController = navController)
        }

    }

}