package com.example.petprojectjus

import android.util.Log
import com.example.petprojectjus.celebrity.data.network.CelebrityService
import com.example.petprojectjus.login.data.network.LoginService
import com.example.petprojectjus.movie.data.network.MovieService
import com.example.petprojectjus.tvshows.data.network.TvService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    fun getMovieApi(): MovieService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
        return retrofit.create(MovieService::class.java)
    }

    fun getLoginApi(): LoginService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
        return retrofit.create(LoginService::class.java)
    }

    fun getTvApi(): TvService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
        return retrofit.create(TvService::class.java)
    }

    fun getCelebrityApi(): CelebrityService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
        return retrofit.create(CelebrityService::class.java)
    }

    private fun getOkHttp(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
        return okHttpClient.build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("OkHttp", message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}