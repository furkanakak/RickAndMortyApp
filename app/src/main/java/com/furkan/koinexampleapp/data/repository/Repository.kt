package com.furkan.koinexampleapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.data.local.LocalDataSource
import com.furkan.koinexampleapp.di.networking.performNetworkOperation
import com.furkan.koinexampleapp.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.dsl.module

val RepositoryModule = module {
    factory { Repository(get(), get()) }
}


open class Repository(private val localDataSource: LocalDataSource ,private val remoteDataSource: RemoteDataSource) {
    var list : MutableLiveData<RickAndMortyResponse> = localDataSource.list
    fun getRickAndMortyResponse(page : Int) = performNetworkOperation {remoteDataSource.getHeroList(page)}

    fun rickAndMortyResponseSetDb(list: ArrayList<Result>) {
        CoroutineScope(Dispatchers.Main).launch {
           localDataSource.addList(list)
        }
    }

    fun rickAndMortyResponseGetDb() {
        CoroutineScope(Dispatchers.Main).launch { localDataSource.getList()}
    }



}