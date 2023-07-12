package com.anilyilmaz.postapp.presentation.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.anilyilmaz.postapp.di.MainRepository
import com.anilyilmaz.postapp.model.User
import com.anilyilmaz.postapp.util.ApiUtils
import com.anilyilmaz.postapp.util.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//@HiltViewModel
//@Inject constructor(private val mainRepository: MainRepository)
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