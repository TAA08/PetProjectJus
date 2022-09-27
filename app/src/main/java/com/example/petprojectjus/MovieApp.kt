package com.example.petprojectjus

import android.app.Application
import com.example.petprojectjus.celebrity.di.CelebrityModule
import com.example.petprojectjus.detail.di.DetailModule
import com.example.petprojectjus.login.di.LoginModule
import com.example.petprojectjus.movie.di.MovieModule
import com.example.petprojectjus.tvshows.di.TVModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(
                MovieModule,
                LoginModule,
                TVModule,
                CelebrityModule,
                DetailModule,
                )
        }
    }
}