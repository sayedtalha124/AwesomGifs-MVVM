package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Original(

        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("size") val size: Int,
        @SerializedName("url") val url: String,
        @SerializedName("mp4_size") val mp4_size: Int,
        @SerializedName("mp4") val mp4: String,
        @SerializedName("webp_size") val webp_size: Int,
        @SerializedName("webp") val webp: String,
        @SerializedName("frames") val frames: Int,
        @SerializedName("hash") val hash: String
) : Serializable