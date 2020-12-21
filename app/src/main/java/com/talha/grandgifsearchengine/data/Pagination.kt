package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName

data class Pagination(

        @SerializedName("total_count") val total_count: Int,
        @SerializedName("count") val count: Int,
        @SerializedName("offset") val offset: Int
)