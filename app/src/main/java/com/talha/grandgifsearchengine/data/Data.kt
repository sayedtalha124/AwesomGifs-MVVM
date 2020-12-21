package com.talha.grandgifsearchengine.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Data(

        @SerializedName("type") val type: String,
        @SerializedName("id") val id: String,
        @SerializedName("url") val url: String,
        @SerializedName("slug") val slug: String,
        @SerializedName("bitly_gif_url") val bitly_gif_url: String,
        @SerializedName("bitly_url") val bitly_url: String,
        @SerializedName("embed_url") val embed_url: String,
        @SerializedName("username") val username: String,
        @SerializedName("source") val source: String,
        @SerializedName("title") val title: String,
        @SerializedName("rating") val rating: String,
        @SerializedName("content_url") val content_url: String,
        @SerializedName("source_tld") val source_tld: String,
        @SerializedName("source_post_url") val source_post_url: String,
        @SerializedName("is_sticker") val is_sticker: Int,
        @SerializedName("import_datetime") val import_datetime: String,
        @SerializedName("trending_datetime") val trending_datetime: String,
        @SerializedName("images") val images: Images,
        @SerializedName("user") val user: User,
        @SerializedName("analytics_response_payload") val analytics_response_payload: String,
) : Serializable