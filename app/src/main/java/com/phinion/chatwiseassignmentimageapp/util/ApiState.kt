package com.phinion.chatwiseassignmentimageapp.util

import com.phinion.chatwiseassignmentimageapp.models.ImageItem
import retrofit2.Response

sealed class ApiState {
    class Success(val data: Response<List<ImageItem>>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading : ApiState()
    object Empty: ApiState()
}