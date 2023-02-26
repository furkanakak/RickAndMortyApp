package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.furkan.koinexampleapp.databinding.RickAndMortyFragmentBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    factory { RickAndMortyFragment()}
}

class RickAndMortyFragment : Fragment() {
    private val viewModel: RickAndMortyViewModel by viewModel()
    lateinit var binding: RickAndMortyFragmentBinding
    var adapter = RickAndMortyListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = RickAndMortyFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            initAdapter()

    }



    private  fun initAdapter() {
         adapter = RickAndMortyListAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.result.collect { pagingData ->
                adapter.submitData(pagingData)
            }
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.loadStateFlow.collect {
                    binding.progressCircular.isVisible = it.source.append is LoadState.Loading
                }
            }
        }

    }



}