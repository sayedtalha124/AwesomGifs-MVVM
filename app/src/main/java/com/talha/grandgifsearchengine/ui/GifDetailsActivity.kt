package com.talha.grandgifsearchengine.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.talha.grandgifsearchengine.R
import com.talha.grandgifsearchengine.data.Data
import com.talha.grandgifsearchengine.data.User
import com.talha.grandgifsearchengine.databinding.ActivityGifDetailsBinding
import com.talha.grandgifsearchengine.utils.loadGif
import com.talha.grandgifsearchengine.utils.loadImage


class GifDetailsActivity : AppCompatActivity() {
    val TAG = "LOG_MESSAGE"
    lateinit var webView: WebView
    lateinit var binding: ActivityGifDetailsBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_gif_details)
        val data = intent.getSerializableExtra("data") as Data
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (data.user != null) {
            setUser(data.user)
            binding.userLayout.visibility = View.GONE
        }
        binding.gif.loadGif(data.images.original.url)

    }

    private fun setUser(user: User) {
        binding.data = user

        binding.imageView.loadImage(user.avatar_url)
        binding.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_correct, 0)

        /*  val webSettings = webView.settings;
          webSettings.javaScriptEnabled = true
          webView.settings.javaScriptEnabled=true
          webView.loadUrl(user.profile_url)
          webView.webViewClient = WebViewClient()*/

        supportActionBar!!.title = user.username


    }

    private class WebClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

            return true
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}