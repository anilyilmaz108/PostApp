package com.anilyilmaz.postapp.service

import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.presentation.ui.login.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FakeApi {
    @GET("/posts")
    suspend fun getAllData(): Response<List<Post>>

    @GET("/users")
    suspend fun getAllUser(): Response<List<User>>

}