package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName


data class Preview_gif(

        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("size") val size: Int,
        @SerializedName("url") val url: String
)