package com.phinion.chatwiseassignmentimageapp.presentation.image_list_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phinion.chatwiseassignmentimageapp.data.repositories.ImageRepository
import com.phinion.chatwiseassignmentimageapp.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {

    var response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        getImagesList()
    }

    fun getImagesList() = viewModelScope.launch {
        repository.getImagesList()
            .onStart {

                response.value = ApiState.Loading

            }
            .catch {

                response.value = ApiState.Failure(it)

            }
            .collect{

                response.value = ApiState.Success(it)

            }
    }



}