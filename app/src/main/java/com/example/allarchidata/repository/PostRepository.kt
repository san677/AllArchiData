package com.example.allarchidata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.allarchidata.API.Apiservice
import com.example.allarchidata.models.PostResponse

class PostRepository(val apiservice: Apiservice) {
    val postlivedata= MutableLiveData<PostResponse>()

    val posts: LiveData<PostResponse>
        get() = postlivedata
    suspend fun getQuotes(page: Int){
        val result=apiservice.getposts(page)
        if (result!=null){
            postlivedata.postValue(result)
        }
    }
}


