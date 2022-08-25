package com.example.petprojectjus

import android.app.Application
import com.example.petprojectjus.movie.di.MovieModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(MovieModule)
        }
    }
}