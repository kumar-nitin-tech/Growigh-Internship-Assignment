package com.example.nitinkumar.retrofit

import com.example.nitinkumar.model.Image
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageServices {
    @GET("/v2/list")
    suspend fun getAllImage(@Query("page") page:Int, @Query("limit") limit: Int): Response<List<Image>>
}