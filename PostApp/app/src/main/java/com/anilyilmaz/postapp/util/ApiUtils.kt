package com.anilyilmaz.postapp.util

import com.anilyilmaz.postapp.service.FakeApi
import com.anilyilmaz.postapp.service.RetrofitClient

class ApiUtils {
    companion object{

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun getFakeApi(): FakeApi {
            return RetrofitClient.getClient(BASE_URL).create(FakeApi::class.java)
        }
    }
}