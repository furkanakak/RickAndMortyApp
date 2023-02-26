package com.furkan.koinexampleapp.application
import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.furkan.koinexampleapp.data.local.LocalDataSourceModule
import com.furkan.koinexampleapp.data.remote.PagingSourceModule
import com.furkan.koinexampleapp.di.networking.networkModule
import com.furkan.koinexampleapp.data.remote.RemoteDataSourceModule
import com.furkan.koinexampleapp.data.repository.RepositoryModule
import com.furkan.koinexampleapp.di.localdb.prefModule
import com.furkan.koinexampleapp.di.localdb.roomDBModule
import com.furkan.koinexampleapp.ui.fragment.rickandmorty.fragmentModule
import com.furkan.koinexampleapp.ui.fragment.rickandmorty.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class KoinExampleAppApplication: Application() , ImageLoaderFactory{
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@KoinExampleAppApplication)
            modules(listOf(prefModule,roomDBModule, networkModule,fragmentModule, viewModelModule,RemoteDataSourceModule, RepositoryModule,LocalDataSourceModule,PagingSourceModule))
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }
}