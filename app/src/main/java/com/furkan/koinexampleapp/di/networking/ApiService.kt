package com.furkan.koinexampleapp.di.networking
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun listCharacters(@Query("page") page: Int): Response<RickAndMortyResponse>

}