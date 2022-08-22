package com.example.petprojectjus.domain.repository

import com.example.petprojectjus.domain.model.GetMovieModel

interface MovieRepository {

    suspend fun getPopularMovieList(page: Int): List<GetMovieModel>

    suspend fun getUpcomingMovieList(page: Int): List<GetMovieModel>

    suspend fun getTopRatedMovieList(page: Int): List<GetMovieModel>

    suspend fun getMovieDetail(movieId: Int): GetMovieModel

    suspend fun getNowPlayingMovies(page: Int): List<GetMovieModel>

    suspend fun getTrendingMovies(page: Int): List<GetMovieModel>
}