package com.phinion.chatwiseassignmentimageapp.data.repositories

import com.phinion.chatwiseassignmentimageapp.data.remote.ImageApi
import com.phinion.chatwiseassignmentimageapp.models.ImageItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageApi: ImageApi) {

    fun getImagesList() : Flow<Response<List<ImageItem>>> = flow {
        emit(imageApi.getAllImages())
    }.flowOn(Dispatchers.IO)

}