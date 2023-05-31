package com.phinion.chatwiseassignmentimageapp.presentation.image_list_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.phinion.chatwiseassignmentimageapp.models.ImageItem
import com.phinion.chatwiseassignmentimageapp.presentation.components.ImageItemLayout
import com.phinion.chatwiseassignmentimageapp.presentation.components.TopAppBar
import com.phinion.chatwiseassignmentimageapp.ui.theme.poppins_regular
import com.phinion.chatwiseassignmentimageapp.util.ApiState

@Composable
fun ImageListScreen(
    imageListViewModel: ImageListViewModel = hiltViewModel(),
    navController: NavController
) {
    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(MaterialTheme.colors.primary)

    val state = rememberLazyListState()

    Column {
        TopAppBar(title = "Images List", backButtonOnClick = {

            navController.popBackStack()

        })

        Spacer(modifier = Modifier.height(16.dp))

        when (val result = imageListViewModel.response.value) {
            is ApiState.Loading -> {

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }

            }

            is ApiState.Failure -> {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "Something went wrong!\nPlease check your internet connection!.", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButton(onClick = {
                        imageListViewModel.getImagesList()
                    }, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth(0.6f)) {
                        Text(text = "Try Again", style = TextStyle(
                            fontFamily = poppins_regular,
                            color = MaterialTheme.colors.primary
                        ))
                    }

                }

            }

            is ApiState.Success -> {

                val imagesList: ArrayList<ImageItem> = result.data.body() as ArrayList<ImageItem>

                val customImageList = imagesList.subList(0, 50)

                LazyColumn(
                    state = state,
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {

                        items(
                            items = customImageList
                        ){ imageItem ->

                            ImageItemLayout(imageItem = imageItem)

                        }


                    }
                )








            }

            is ApiState.Empty -> {



            }
        }

    }



}

fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1