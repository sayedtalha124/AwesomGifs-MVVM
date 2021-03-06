package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DownsizedSmall(
        @SerializedName("url") val url: String,

        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
) : Serializable
