package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName


data class BaseData(

        @SerializedName("data") val data: List<Data>,
        @SerializedName("pagination") val pagination: Pagination,
)