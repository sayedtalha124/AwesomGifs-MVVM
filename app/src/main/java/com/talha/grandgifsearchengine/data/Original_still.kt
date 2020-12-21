package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName


data class Original_still(

        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("size") val size: Int,
        @SerializedName("url") val url: String
)