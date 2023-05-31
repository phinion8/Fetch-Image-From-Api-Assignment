package com.phinion.chatwiseassignmentimageapp.di

import com.phinion.chatwiseassignmentimageapp.data.remote.ImageApi
import com.phinion.chatwiseassignmentimageapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ImageApi =
        Retrofit.Builder()
            .run {
                baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            .create(ImageApi::class.java)

}