package com.example.petprojectjus.celebrity.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CelebrityService {

    @GET("$PERSON/popular")
    suspend fun getPopularCelebrity(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): CelebrityListDto

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingCelebrity(
        @Path("media_type") mediaType: String = PERSON,
        @Path("time_window") timeWindow: String = TODAY,
        @Query("api_key") apiKey: String = API_KEY,
    ): CelebrityListDto

    @GET("person/{person_id}")
    suspend fun getCelebrityDetails(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): CelebrityInfoDto

    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
        private var LANGUAGE = "ru"
        private const val PERSON = "person"
        private const val TODAY = "day"
    }
}