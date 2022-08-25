package com.example.petprojectjus.movie.domain.interactor

import com.example.petprojectjus.movie.domain.model.GetMovieModel
import com.example.petprojectjus.movie.domain.repository.MovieRepository

class MovieInteractor(
    private val movieRepository: MovieRepository,

    ) {

    suspend fun getPopularMovieList(page: Int): List<GetMovieModel> =
        movieRepository.getPopularMovieList(page)

    suspend fun getMovie(movieId: Int): GetMovieModel = movieRepository.getMovieDetail(movieId)

    suspend fun getUpcomingMovieList(page: Int): List<GetMovieModel> =
        movieRepository.getUpcomingMovieList(page)

    suspend fun getTopRatedMovieList(page: Int): List<GetMovieModel> =
        movieRepository.getTopRatedMovieList(page)

    suspend fun getNowPlayingMovies(page: Int): List<GetMovieModel> =
        movieRepository.getNowPlayingMovies(page)

    suspend fun getTrendingMovies(page: Int): List<GetMovieModel> =
        movieRepository.getTrendingMovies(page)

    suspend fun getSimilarMovies(movieId: Int): List<GetMovieModel> =
        movieRepository.getSimilarMovies(movieId)

    suspend fun getRecommendationsMovies(movieId: Int): List<GetMovieModel> =
        movieRepository.getRecommendationsMovies(movieId)
}
