package com.example.petprojectjus.detail.domain.repository

import com.example.petprojectjus.detail.domain.model.CastCrew
import com.example.petprojectjus.detail.domain.model.MovieDetail
import com.example.petprojectjus.detail.domain.model.MovieModel
import com.example.petprojectjus.detail.domain.model.Trailer

interface MovieDetailRepository {

    suspend fun getMovieDetail(movieId: Int): MovieDetail

    suspend fun getCastCrew(movieId: Int): CastCrew

    suspend fun getMovieTrailer(movieId: Int): Trailer

    suspend fun getSimilarMovie(movieId: Int): List<MovieModel>

    suspend fun getRecommendMovie(movieId: Int): List<MovieModel>
}