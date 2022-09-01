package com.example.petprojectjus.tvshows.data.network

import com.example.petprojectjus.tvshows.data.network.Dto.GetTVListResponse
import okhttp3.MediaType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvService {

    @GET("$TV/popular")
    fun getPopularShows(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): GetTVListResponse

    @GET("$TV/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): GetTVListResponse

    @GET("$TV/airing_today")
    fun getAiringToday(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): GetTVListResponse

    @GET("trending/{media_type}/{time_window}")
    fun getTrendingTv(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Path("media_type") mediaType: String = TV,
        @Path("time_window") timeWindow: String = WEEK
    ): GetTVListResponse

    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
        private var LANGUAGE = "ru"
        private const val TV = "tv"
        private const val WEEK = "week"
    }
}