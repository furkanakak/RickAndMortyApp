package com.furkan.koinexampleapp.data.local

import androidx.lifecycle.MutableLiveData
import com.furkan.koinexampleapp.common.Constants
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.di.localdb.ItemDao
import com.furkan.koinexampleapp.di.localdb.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.koin.dsl.module

val LocalDataSourceModule = module {
    single { LocalDataSource(get(),get()) }
}

class LocalDataSource( private val sharedPrefManager: Preferences, private val itemDao: ItemDao) {
    var list : MutableLiveData<RickAndMortyResponse> = MutableLiveData()

    suspend fun getList(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            list.postValue(itemDao.getList(Constants.DB_Item_Id))
        }
    }

    suspend fun addList(list: ArrayList<Result>) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            itemDao.addList(RickAndMortyResponse(Constants.DB_Item_Id,list))
        }

    }




}