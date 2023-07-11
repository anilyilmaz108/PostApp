package com.anilyilmaz.postapp.service

import com.anilyilmaz.postapp.model.Comment
import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.model.PostData
import com.anilyilmaz.postapp.model.Todo
import com.anilyilmaz.postapp.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface FakeApi {
    @GET("/posts")
    suspend fun getAllData(): Response<List<Post>>

    @POST("posts")
    open fun createPost(@Body dataModal: PostData?): Call<PostData>

    @GET("/users")
    suspend fun getAllUser(): Response<List<User>>

    @GET("/comments")
    suspend fun getAllComment(): Response<List<Comment>>

    @GET("/todos")
    suspend fun getTodos(@Query("userId") userId: Int): Response<List<Todo>>
}