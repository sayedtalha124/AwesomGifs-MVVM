package com.talha.grandgifsearchengine.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.talha.grandgifsearchengine.R

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun ImageView.loadGif(imageUrl: String) {
    Glide.with(this).asGif()
            .load(imageUrl)
            .placeholder(R.drawable.ic_loading)
            .thumbnail(1f)
            .fitCenter().listener(object : RequestListener<GifDrawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<GifDrawable>?, isFirstResource: Boolean): Boolean {
                    Log.d("LOG_MESSAGE", "onLoadFailed: " + e)

                    return false
                }

                override fun onResourceReady(resource: GifDrawable?, model: Any?, target: Target<GifDrawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                    return false
                }

            })
            .into(this)
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.ic_loading)
            .thumbnail(1f)
            .fitCenter()
            .into(this)
}
