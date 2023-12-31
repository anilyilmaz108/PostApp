package com.anilyilmaz.postapp.presentation.ui.share

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
//import com.anilyilmaz.postapp.di.MainRepository
import com.anilyilmaz.postapp.model.PostData
import com.anilyilmaz.postapp.util.ApiUtils
import com.anilyilmaz.postapp.util.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//@HiltViewModel
//@Inject constructor(private val mainRepository: MainRepository)
class ShareViewModel : ViewModel() {

    fun postData(userId: Int, title: String, body: String){

        val modal = PostData(userId,title,body)
        val call: Call<PostData> = ApiUtils.getFakeApi().createPost(modal)

        call.enqueue(object : Callback<PostData?> {
            override fun onResponse(call: Call<PostData?>?, response: Response<PostData?>) {
                Log.e("Passed","Data gonderildi")
            }

            override fun onFailure(call: Call<PostData?>, t: Throwable) {
                Log.e("Fail","Data gonderilemedi")
            }
        })
    }
}