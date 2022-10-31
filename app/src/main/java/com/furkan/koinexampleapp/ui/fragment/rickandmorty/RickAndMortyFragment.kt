package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.di.networking.Resource
import com.furkan.koinexampleapp.databinding.RickAndMortyFragmentBinding
import com.furkan.koinexampleapp.di.localdb.Preferences
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    factory { RickAndMortyFragment()}
}

class RickAndMortyFragment() : Fragment() {
    private val viewModel: RickAndMortyViewModel by viewModel()
    var binding: RickAndMortyFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = RickAndMortyFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

    }

    private fun setData(value : RickAndMortyResponse) {
        viewModel.addHeroList(value)
    }

    private fun getData() {
        viewModel.getHeroList().observe(viewLifecycleOwner){ response ->
            when(response.status){
                Resource.Status.LOADING ->{Log.v("callresponse","LOADING")}
                Resource.Status.SUCCESS  ->{ response.data?.let { setData(it) }}
                Resource.Status.ERROR  ->{Log.v("callresponse","${response.message}")}
            }

        }

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }



}