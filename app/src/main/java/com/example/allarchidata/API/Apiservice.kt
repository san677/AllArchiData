package com.example.allarchidata.API

import com.example.allarchidata.models.PostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiservice {
    @GET("posts")
    suspend fun getposts(@Query("page")page: Int): PostResponse
}