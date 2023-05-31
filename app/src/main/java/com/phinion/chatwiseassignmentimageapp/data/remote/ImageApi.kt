package com.phinion.chatwiseassignmentimageapp.data.remote

import com.phinion.chatwiseassignmentimageapp.models.ImageItem
import retrofit2.Response
import retrofit2.http.GET

interface ImageApi {

    @GET("photos")
    suspend fun getAllImages(): Response<List<ImageItem>>

}