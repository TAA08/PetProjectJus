package com.example.petprojectjus.detail.data.network

import com.example.petprojectjus.detail.data.network.modelDTO.CastCrewResponse
import com.example.petprojectjus.detail.data.network.modelDTO.MovieDetailResponse
import com.example.petprojectjus.detail.data.network.modelDTO.TrailerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {

    @GET("${MOVIE}/{$MOVIE_ID}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): MovieDetailResponse

    @GET("${MOVIE}/{$MOVIE_ID}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): MovieDetailResponse

    @GET("${MOVIE}/{$MOVIE_ID}/recommendations")
    suspend fun getRecommendationsMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): MovieDetailResponse

    @GET("${MOVIE}/{$MOVIE_ID}/credits")
    suspend fun getCastCrew(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): CastCrewResponse

    @GET("${MOVIE}/{$MOVIE_ID}/videos")
    suspend fun getTrailer(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): TrailerResponse

    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
        private var LANGUAGE = "ru"
        private const val MOVIE = "movie"
        private const val MOVIE_ID = "movie_id"
    }
}