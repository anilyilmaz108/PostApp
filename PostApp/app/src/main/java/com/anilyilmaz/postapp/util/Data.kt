package com.anilyilmaz.postapp.util

import androidx.lifecycle.MutableLiveData
import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.presentation.ui.login.User

class Data {

    companion object{
        var postList = ArrayList<Post>()
        var validateUser = User(0,"","","","","")
        var userList = ArrayList<User>()

        var id: Int = 0
        var name: String = ""
        var email: String = ""
        var username = ""
        var phone = ""
        var website = ""


    }
}