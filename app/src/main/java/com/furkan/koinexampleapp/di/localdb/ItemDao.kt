package com.furkan.koinexampleapp.di.localdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse

@Dao
interface ItemDao {

    @Query("SELECT * FROM dbModel")
    suspend fun getList(): RickAndMortyResponse

    @Insert
    suspend fun addList(item: RickAndMortyResponse)

    @Delete
   suspend fun deleteList(item: RickAndMortyResponse)
}