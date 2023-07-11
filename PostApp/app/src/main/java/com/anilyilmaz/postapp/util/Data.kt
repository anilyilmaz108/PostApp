package com.anilyilmaz.postapp.util

import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.model.User
import com.anilyilmaz.postapp.model.Todo

class Data {

    companion object{
        var postList = ArrayList<Post>()
        var validateUser = User(0,"","","","","")
        var userList = ArrayList<User>()
        var todoList = ArrayList<Todo>()
        var id: Int = 0
        var name: String = ""
        var email: String = ""
        var username = ""
        var phone = ""
        var website = ""


    }
}