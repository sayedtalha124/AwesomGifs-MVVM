package com.talha.grandgifsearchengine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.talha.grandgifsearchengine.ViewModel
import com.talha.grandgifsearchengine.data.Data
import com.talha.grandgifsearchengine.databinding.EntertainmentAdapterBinding
import com.talha.grandgifsearchengine.utils.loadGif

class GifAdapter(var viewModel: ViewModel) :
        PagingDataAdapter<Data, GifAdapter.PassengersViewHolder>(PassengersComparator) {


    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): PassengersViewHolder {
        return PassengersViewHolder(
                EntertainmentAdapterBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item.let { holder.bindPassenger(it!!) }

    }

    inner class PassengersViewHolder(private val binding: EntertainmentAdapterBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bindPassenger(item: Data) = with(binding) {
            imageView.loadGif(item.images.downsized_small.url)
            itemView.setOnClickListener {
                viewModel.setData(item)
            }


        }
    }

    object PassengersComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

}