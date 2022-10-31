package com.furkan.koinexampleapp.di.localdb

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val prefModule = module {
    single { Preferences(androidContext()) }
}

class Preferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("KoinExampleApplication", Context.MODE_PRIVATE)
    private val stringValue = "MainActivity"

    private fun saveString(key: String, value: String) {
        preferences.let {
            val editor = it.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    private fun getString(key: String, defaultVal: String = ""): String {
        return preferences.getString(key, defaultVal) ?: ""
    }

    fun saveString(value: String) {
        saveString(stringValue, value)
    }

    fun getString(): String {
        return getString(stringValue)
    }


}