package com.example.allarchidata

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.allarchidata.API.Apiservice
import com.example.allarchidata.API.RetrofitHelper
import com.example.allarchidata.repository.PostRepository
import com.example.allarchidata.veiwmodels.Mainviewmodel
import com.example.allarchidata.veiwmodels.MainviewmodelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel: Mainviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val postservice= RetrofitHelper.getInstance().create(Apiservice::class.java)
        val repository= PostRepository(postservice)
        mainviewmodel= ViewModelProvider(this, MainviewmodelFactory(repository)).get(Mainviewmodel::class.java)

        mainviewmodel.posts.observe(this, Observer{
           // Log.d("Kotlinfun", )
        })
        fetchdata()

    }

    private fun fetchdata() {
        CoroutineScope(Dispatchers.IO).launch {

                val post1 = RetrofitHelper.api.getposts(1)

                Log.d("Kotlinfun", post1.toString())




        }}}


