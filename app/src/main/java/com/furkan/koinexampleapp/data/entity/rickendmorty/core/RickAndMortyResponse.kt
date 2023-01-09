package com.furkan.koinexampleapp.data.entity.rickendmorty.core
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.furkan.koinexampleapp.di.localdb.Converters
import java.io.Serializable



@Entity(tableName = "dbModel")
data class RickAndMortyResponse(
    @PrimaryKey
    @ColumnInfo
    var id: Int,

    @ColumnInfo
    @TypeConverters(Converters::class)
    val results: ArrayList<Result> = ArrayList()) : Serializable