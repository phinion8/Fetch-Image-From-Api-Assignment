package com.phinion.chatwiseassignmentimageapp.util

sealed class Screen(val route: String){
    object StartScreen: Screen(route = "start_screen")
    object ImageListScreen: Screen(route = "image_list_screen")
}
