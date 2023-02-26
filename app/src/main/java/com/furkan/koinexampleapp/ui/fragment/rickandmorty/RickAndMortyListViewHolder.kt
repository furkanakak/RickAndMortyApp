package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.furkan.koinexampleapp.databinding.RickandmortyRecyclerItemBinding

class RickAndMortyListViewHolder(private val binding: RickandmortyRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result){
        binding.apply {
            itemName.text = result.name
            itemGender.text = result.gender
            itemStatus.text = result.status
            itemImage.load(result.image)

        }
    }



}