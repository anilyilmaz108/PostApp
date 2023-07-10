package com.anilyilmaz.postapp.util

import androidx.lifecycle.MutableLiveData
import com.anilyilmaz.postapp.model.Post

class Data {

    companion object{
        var postList = ArrayList<Post>()
        //var mutablePostList = MutableLiveData<List<Post>>()
    }
}