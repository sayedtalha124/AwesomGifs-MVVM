package com.talha.grandgifsearchengine.retrofit

import com.talha.grandgifsearchengine.ApiInterface

class ApiUtils {
    var Base = "https://api.giphy.com/v1/"

    fun getService(): ApiInterface {
        val retrofitClient = RetrofitClient()
        return retrofitClient.getClient(Base).create(ApiInterface::class.java)
    }


}
