package com.furkan.koinexampleapp.di.localdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.furkan.koinexampleapp.common.Constants
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.RickAndMortyResponse

@Dao
interface ItemDao {

    @Query("SELECT * FROM dbModel WHERE id = :id")
    suspend fun getList(id : Int): RickAndMortyResponse

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun addList(item: RickAndMortyResponse)


}