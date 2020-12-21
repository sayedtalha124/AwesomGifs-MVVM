package com.talha.grandgifsearchengine

import com.talha.grandgifsearchengine.data.BaseData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("gifs/trending")
    suspend fun getGifs(@Query("api_key") api_key: String?,
                        @Query("limit") limit: String? = "25",
                        @Query("rating") rating: String = "r"): BaseData

    @GET("gifs/search")
    suspend fun getSearch(@Query("api_key") api_key: String?,
                          @Query("limit") limit: String? = "25",
                          @Query("q") rating: String?): BaseData
}
