package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.di.networking.Resource
import com.furkan.koinexampleapp.data.repository.Repository
import org.koin.dsl.module


val viewModelModule = module {
    factory { RickAndMortyViewModel(get()) }
}

class RickAndMortyViewModel( private val repository: Repository) : ViewModel() {
    var listLocalDb : MutableLiveData<RickAndMortyResponse> = repository.list

    fun getHeroList(): LiveData<Resource<RickAndMortyResponse>> = repository.getRickAndMortyResponse()

    fun rickAndMortyResponseSetDb(item: ArrayList<Result>) {
       repository.rickAndMortyResponseSetDb(item)
    }

    fun rickAndMortyResponseGetDb() {
        repository.rickAndMortyResponseGetDb()
    }
}