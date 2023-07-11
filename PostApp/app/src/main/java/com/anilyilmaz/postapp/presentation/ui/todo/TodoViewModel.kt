package com.anilyilmaz.postapp.presentation.ui.todo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anilyilmaz.postapp.model.Todo
import com.anilyilmaz.postapp.util.ApiUtils
import com.anilyilmaz.postapp.util.Data
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel : ViewModel() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }
    var job : Job? = null
    var todoList = MutableLiveData<ArrayList<Todo>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getTodoFromApi(): MutableLiveData<ArrayList<Todo>> {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = ApiUtils.getFakeApi().getTodos(Data.id)
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    response.body()?.let {
                        Data.todoList = ArrayList(it)
                        todoList.value = Data.todoList
                        //postList.postValue(response.body())
                        //Log.e("Title","${postList.value?.get(0)?.title}")
                        Log.e("todoListSize","==> ${todoList.value?.size}")
                        Log.e("DataTodoListSize","==> ${Data.userList.size}")
                        loading.value = false

                    }

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
        return todoList
    }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}