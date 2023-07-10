package com.anilyilmaz.postapp.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.util.ApiUtils
import com.anilyilmaz.postapp.util.Data
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }
    var job : Job? = null
    var postList = MutableLiveData<ArrayList<Post>>()
    //var postList = ArrayList<Post>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getDataFromApi(): MutableLiveData<ArrayList<Post>>{

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = ApiUtils.getFakeApi().getAllData()
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    response.body()?.let {
                        Data.postList = ArrayList(it)
                        postList.value = Data.postList
                        //postList.postValue(response.body())
                        //Log.e("Title","${postList.value?.get(0)?.title}")
                        Log.e("postSize","==> ${postList.value?.size}")
                        loading.value = false

                    }

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
        return postList
        }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }


}