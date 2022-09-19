package com.example.petprojectjus.detail.domain.repository

import com.example.petprojectjus.detail.domain.model.Cast
import com.example.petprojectjus.detail.domain.model.Crew
import com.example.petprojectjus.detail.domain.model.MovieDetail
import com.example.petprojectjus.detail.domain.model.Result

interface MovieDetailRepository {

    suspend fun getMovieDetail(movieId: Int): MovieDetail

    suspend fun getMovieCast(movieId: Int): List<Cast>

    suspend fun getMovieCrew(movieId: Int): List<Crew>

    suspend fun getMovieTrailer(movieId: Int): List<Result>

    suspend fun getSimilarMovie(movieId: Int): MovieDetail

    suspend fun getRecommendMovie(movieId: Int): MovieDetail
}