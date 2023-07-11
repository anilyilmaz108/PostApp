package com.anilyilmaz.postapp.presentation.ui.login

import android.util.Log
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }
    var job : Job? = null
    var userList = MutableLiveData<ArrayList<User>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getUserFromApi(): MutableLiveData<ArrayList<User>>{

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = ApiUtils.getFakeApi().getAllUser()
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    response.body()?.let {
                        Data.userList = ArrayList(it)
                        userList.value = Data.userList
                        //postList.postValue(response.body())
                        //Log.e("Title","${postList.value?.get(0)?.title}")
                        Log.e("userListSize","==> ${userList.value?.size}")
                        Log.e("DatauserListSize","==> ${Data.userList.size}")
                        loading.value = false

                    }

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
        return userList
    }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }





}