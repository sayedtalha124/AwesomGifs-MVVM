package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName


data class Preview(

        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("mp4_size") val mp4_size: Int,
        @SerializedName("mp4") val mp4: String
)