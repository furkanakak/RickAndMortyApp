package com.furkan.koinexampleapp.di.networking
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun listCharacters(): Response<RickAndMortyResponse>

}