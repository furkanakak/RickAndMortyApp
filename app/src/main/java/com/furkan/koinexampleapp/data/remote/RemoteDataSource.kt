package com.furkan.koinexampleapp.data.remote

import com.furkan.koinexampleapp.di.networking.ApiService
import com.furkan.koinexampleapp.di.networking.BaseDataSource
import org.koin.dsl.module


val RemoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {
    suspend fun getHeroList() = getResult { apiService.listCharacters() }
}