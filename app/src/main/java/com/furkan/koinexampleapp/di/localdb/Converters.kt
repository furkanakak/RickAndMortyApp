package com.furkan.koinexampleapp.di.localdb
import androidx.room.TypeConverter
import com.furkan.koinexampleapp.data.entity.rickendmorty.core.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun listToString(user: ArrayList<Result>): String {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun stringToList(value: String): ArrayList<Result> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<Result>>() {}.type)
    }

}