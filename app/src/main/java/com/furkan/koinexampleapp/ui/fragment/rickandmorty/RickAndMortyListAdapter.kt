package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.databinding.RickandmortyRecyclerItemBinding

class RickAndMortyListAdapter : PagingDataAdapter<Result,RickAndMortyListViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyListViewHolder =
        RickAndMortyListViewHolder(RickandmortyRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RickAndMortyListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }

}