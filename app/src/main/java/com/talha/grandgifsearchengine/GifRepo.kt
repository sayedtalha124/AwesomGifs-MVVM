package com.talha.grandgifsearchengine

import com.talha.grandgifsearchengine.data.BaseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GifRepo {
    fun setViews(call: Call<BaseData>) {
        call.enqueue(object : Callback<BaseData> {
            override fun onResponse(call: Call<BaseData>, response: Response<BaseData>) {

            }

            override fun onFailure(call: Call<BaseData>, t: Throwable) {
            }
        })
    }

}