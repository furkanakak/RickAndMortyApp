package com.furkan.koinexampleapp.data.local

import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import com.furkan.koinexampleapp.di.localdb.ItemDao
import com.furkan.koinexampleapp.di.localdb.Preferences

import org.koin.dsl.module

val LocalDataSourceModule = module {
    single { LocalDataSource(get(),get()) }
}

class LocalDataSource( private val sharedPrefManager: Preferences, private val itemDao: ItemDao) {

    suspend fun getList(): RickAndMortyResponse {
        return itemDao.getList()
    }

    suspend fun addList(list: RickAndMortyResponse) {
        itemDao.addList(list)
    }

    suspend fun deleteList(item: RickAndMortyResponse) {
        itemDao.deleteList(item)
    }


}