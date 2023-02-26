package com.furkan.koinexampleapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.di.networking.ApiService
import kotlinx.coroutines.delay
import org.koin.dsl.module


val PagingSourceModule = module {
    single { RickAndMortyPagingSource(get()) }
}

class RickAndMortyPagingSource(private val apiService: ApiService) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val startKey = params.key ?: 0
        if (startKey != 0)
            delay(1000)
        return try {
            val page = params.key ?: 1
            val response = apiService.listCharacters(page)
            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.body()!!.results.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }





}