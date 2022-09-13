package com.example.petprojectjus.movie.data.repository

import com.example.petprojectjus.movie.data.mapper.MovieModelMapper
import com.example.petprojectjus.movie.data.network.MovieService
import com.example.petprojectjus.movie.domain.model.GetMovieModel
import com.example.petprojectjus.movie.domain.repository.MovieRepository

class DefaultMovieRepository(
    private val movieApi: MovieService,
    private val movieModelMapper: MovieModelMapper
) : MovieRepository {

    override suspend fun getPopularMovieList(page: Int): List<GetMovieModel> {
//        val response = movieService.getPostApi().getPopularMovies()
//        if (response.isSuccessful) {
//            val result = response.body()?.getMovieModels
//            if (!result.isNullOrEmpty()) {
//                return result.map { movieModelMapper.toGetMovieModel(it) }
//            }
//        }
        return try {
            val movieList = movieApi.getPopularMovies().getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    /**
     * get List of Similar Movies when navigate movie detail
     */
    override suspend fun getSimilarMovies(movieId: Int): List<GetMovieModel> {

        return try {
            val movieList = movieApi.getSimilarMovies(movieId).getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }

    }

    /**
     * get List of Recommendations Movies when navigate movie detail
     */
    override suspend fun getRecommendationsMovies(movieId: Int): List<GetMovieModel> {
        return try {
            val movieList = movieApi.getRecommendationsMovies(movieId).getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }

    }

    override suspend fun getUpcomingMovieList(page: Int): List<GetMovieModel> {
        return try {
            val movieList = movieApi.getUpcomingMovies().getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getNowPlayingMovies(page: Int): List<GetMovieModel> {
        return try {
            val movieList = movieApi.getNowPlayingMovies().getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }

    }

    override suspend fun getTrendingMovies(page: Int): List<GetMovieModel> {
        return try {
            val movieList = movieApi.getTrendingMovies().getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }

    }

    override suspend fun getTopRatedMovieList(page: Int): List<GetMovieModel> {
        return try {
            val movieList = movieApi.getTopRatedMovies().getMovieModels ?: emptyList()
            movieList.map { movieModelMapper.toGetMovieModel(it) }
        } catch (e: Exception) {
            emptyList()
        }

    }

    override suspend fun getMovieDetail(movieId: Int): GetMovieModel {
        TODO("Not yet implemented")
    }

}