package com.example.allarchidata.veiwmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allarchidata.models.PostResponse
import com.example.allarchidata.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext.get

class Mainviewmodel(val repository: PostRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)

        }
    }
        val posts: LiveData<PostResponse>
        get()=repository.posts
    }

