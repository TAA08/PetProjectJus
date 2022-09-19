package com.example.petprojectjus.detail.domain.interactor

import com.example.petprojectjus.detail.domain.model.Cast
import com.example.petprojectjus.detail.domain.model.Crew
import com.example.petprojectjus.detail.domain.model.MovieDetail
import com.example.petprojectjus.detail.domain.model.Result
import com.example.petprojectjus.detail.domain.repository.MovieDetailRepository

class MovieDetailInteractor(
    val movieDetailRepository: MovieDetailRepository
) {
    suspend fun getMovieDetail(movieId: Int): MovieDetail =
        movieDetailRepository.getMovieDetail(movieId)

    suspend fun getMovieCast(movieId: Int): List<Cast> = movieDetailRepository.getMovieCast(movieId)

    suspend fun getMovieCrew(movieId: Int): List<Crew> = movieDetailRepository.getMovieCrew(movieId)

    suspend fun getMovieTrailer(movieId: Int): List<Result> =
        movieDetailRepository.getMovieTrailer(movieId)

    suspend fun getSimilarMovie(movieId: Int): MovieDetail =
        movieDetailRepository.getSimilarMovie(movieId)

    suspend fun getRecommendMovie(movieId: Int): MovieDetail =
        movieDetailRepository.getRecommendMovie(movieId)
}