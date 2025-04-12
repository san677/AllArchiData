package com.example.allarchidata.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper  {
    fun getInstance(): Retrofit{
       return Retrofit.Builder()
           .baseUrl("https://jsonplaceholder.typicode.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
    val api= RetrofitHelper.getInstance().create(Apiservice::class.java)
}