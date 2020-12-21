package com.talha.grandgifsearchengine

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.talha.grandgifsearchengine.data.Data
import com.talha.grandgifsearchengine.databinding.ActivityMainBinding
import com.talha.grandgifsearchengine.retrofit.ApiUtils
import com.talha.grandgifsearchengine.ui.GifDetailsActivity
import com.talha.grandgifsearchengine.ui.adapter.GifAdapter
import com.talha.grandgifsearchengine.ui.adapter.ItemLoadingAdapter
import com.talha.grandgifsearchengine.utils.SpacesItemDecoration


class MainActivity : AppCompatActivity() {
    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val passengersAdapter = GifAdapter(viewModel)
        val api = ApiUtils()
        apiInterface = api.getService()
        val spacingInPixels = 20
        recyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))
        recyclerView.adapter = passengersAdapter.withLoadStateHeaderAndFooter(
                header = ItemLoadingAdapter { passengersAdapter.retry() },
                footer = ItemLoadingAdapter { passengersAdapter.retry() }
        )
        viewModel.getList(apiInterface).observe(this, {
            passengersAdapter.submitData(this.lifecycle, it)
        })
        viewModel.loadData.observe(this, {
            val data = it as Data
            val intent = Intent(this, GifDetailsActivity::class.java)
            intent.putExtra("data", data)
            startActivity(intent)

        })

    }
}