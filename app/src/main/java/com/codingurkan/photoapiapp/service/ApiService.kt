package com.codingurkan.photoapiapp.service

import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.model.PhotoResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/")
    suspend fun getImageList(
        @Query("key") apiKey : String
    ) : Response<PhotoResponseModel>


    @GET("details")
    suspend fun getImageDetails() : Response<Hit>

}