package com.anilyilmaz.postapp.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anilyilmaz.postapp.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {
    @GET("/posts")
    suspend fun getAllData(): Response<List<Post>>

}