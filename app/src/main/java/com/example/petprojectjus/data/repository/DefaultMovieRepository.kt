package com.example.petprojectjus.data.repository

import com.example.petprojectjus.data.mapper.MovieModelMapper
import com.example.petprojectjus.data.network.RetrofitInstance
import com.example.petprojectjus.domain.model.GetMovieModel
import com.example.petprojectjus.domain.repository.MovieRepository

class DefaultMovieRepository(
    private val movieService: RetrofitInstance,
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
        val movieList = movieService.getMovieApi().getPopularMovies().getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    /**
     * get List of Similar Movies when navigate movie detail
     */
    override suspend fun getSimilarMovies(movieId: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getSimilarMovies(movieId).getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    /**
     * get List of Recommendations Movies when navigate movie detail
     */
    override suspend fun getRecommendationsMovies(movieId: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getRecommendationsMovies(movieId).getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    override suspend fun getUpcomingMovieList(page: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getUpcomingMovies().getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    override suspend fun getNowPlayingMovies(page: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getNowPlayingMovies().getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    override suspend fun getTrendingMovies(page: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getTrendingMovies().getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    override suspend fun getTopRatedMovieList(page: Int): List<GetMovieModel> {
        val movieList = movieService.getMovieApi().getTopRatedMovies().getMovieModels
        return movieList.map { movieModelMapper.toGetMovieModel(it) }
    }

    override suspend fun getMovieDetail(movieId: Int): GetMovieModel {
        TODO("Not yet implemented")
    }

}