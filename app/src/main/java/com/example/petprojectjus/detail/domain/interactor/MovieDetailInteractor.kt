package com.example.petprojectjus.detail.domain.interactor

import com.example.petprojectjus.detail.domain.model.*
import com.example.petprojectjus.detail.domain.repository.MovieDetailRepository

class MovieDetailInteractor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend fun getMovieDetail(movieId: Int): MovieDetail =
        movieDetailRepository.getMovieDetail(movieId)

    suspend fun getMovieTrailer(movieId: Int): Trailer =
        movieDetailRepository.getMovieTrailer(movieId)

    suspend fun getSimilarMovie(movieId: Int): List<MovieModel> =
        movieDetailRepository.getSimilarMovie(movieId)

    suspend fun getRecommendMovie(movieId: Int): List<MovieModel> =
        movieDetailRepository.getRecommendMovie(movieId)

    suspend fun getCastCrew(movieId: Int): CastCrew = movieDetailRepository.getCastCrew(movieId)
}