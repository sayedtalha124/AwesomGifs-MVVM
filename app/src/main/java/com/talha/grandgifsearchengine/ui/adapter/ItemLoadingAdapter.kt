package com.talha.grandgifsearchengine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.talha.grandgifsearchengine.databinding.ItemLoadingStateBinding
import com.talha.grandgifsearchengine.utils.visible

class ItemLoadingAdapter(
        private val retry: () -> Unit
) : LoadStateAdapter<ItemLoadingAdapter.PassengerLoadStateViewHolder>() {

    inner class PassengerLoadStateViewHolder(
            private val binding: ItemLoadingStateBinding,
            private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.textViewError.text = "Something went wrong"
            }
            binding.progressbar.visible(loadState is LoadState.Loading)
            binding.buttonRetry.visible(loadState is LoadState.Error)
            binding.textViewError.visible(loadState is LoadState.Error)
            binding.buttonRetry.setOnClickListener {
                retry()
            }
        }
    }

    override fun onBindViewHolder(holder: PassengerLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            loadState: LoadState
    ) = PassengerLoadStateViewHolder(
            ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            retry
    )
}