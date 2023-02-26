package com.furkan.koinexampleapp.ui.fragment.rickandmorty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.data.remote.RickAndMortyPagingSource
import com.furkan.koinexampleapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module


val viewModelModule = module {
    factory { RickAndMortyViewModel(get(),get()) }
}

class RickAndMortyViewModel(repository: Repository, var rickAndMortyPagingSource : RickAndMortyPagingSource) : ViewModel() {
    var listLocalDb : MutableLiveData<RickAndMortyResponse> = repository.list
    val result : Flow<PagingData<Result>> = Pager(config = PagingConfig(pageSize = 1, enablePlaceholders = false), pagingSourceFactory = { rickAndMortyPagingSource}).flow.cachedIn(viewModelScope)

}

