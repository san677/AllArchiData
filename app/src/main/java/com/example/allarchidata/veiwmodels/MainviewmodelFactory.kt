package com.example.allarchidata.veiwmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.allarchidata.repository.PostRepository

class MainviewmodelFactory(val repository: PostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Mainviewmodel(repository) as T
    }
}