package com.example.petprojectjus.movie.data.network

import com.example.petprojectjus.movie.data.network.modelDTO.GetMoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("$MOVIE/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse

    @GET("$MOVIE/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse

    @GET("$MOVIE/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse

    @GET("$MOVIE/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String = MOVIE,
        @Path("time_window") timeWindow: String = WEEK,
        @Query("api_key") apiKey: String = API_KEY,
    ): GetMoviesListResponse

    @GET("$MOVIE/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse

    @GET("$MOVIE/{movie_id}/recommendations")
    suspend fun getRecommendationsMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
    ): GetMoviesListResponse



    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
        private var LANGUAGE = "ru"
        private const val MOVIE = "movie"
        private const val WEEK = "week"
    }
}