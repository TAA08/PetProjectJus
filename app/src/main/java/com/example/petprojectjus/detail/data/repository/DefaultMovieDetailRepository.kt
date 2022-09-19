package com.example.petprojectjus.detail.data.repository

import com.example.petprojectjus.detail.data.mapper.CastCrewMapper
import com.example.petprojectjus.detail.data.mapper.MovieDetailMapper
import com.example.petprojectjus.detail.data.mapper.TrailerMapper
import com.example.petprojectjus.detail.data.network.MovieDetailService
import com.example.petprojectjus.detail.domain.model.Cast
import com.example.petprojectjus.detail.domain.model.Crew
import com.example.petprojectjus.detail.domain.model.MovieDetail
import com.example.petprojectjus.detail.domain.model.Result
import com.example.petprojectjus.detail.domain.repository.MovieDetailRepository

class DefaultMovieDetailRepository(
    val api : MovieDetailService,
    val movieDetailMapper: MovieDetailMapper,
    val crewMapper: CastCrewMapper,
    val trailerMapper: TrailerMapper
) : MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        val  list = api.getMovieDetail(id = movieId)
        return movieDetailMapper.toGetMovieDetailModel(list)
    }

    override suspend fun getMovieCast(movieId: Int): List<Cast> {
        val list = crewMapper.toGetCastCrewModel(api.getCastCrew(id = movieId))
        return list.cast
    }

    override suspend fun getMovieCrew(movieId: Int): List<Crew> {
        val list = crewMapper.toGetCastCrewModel(api.getCastCrew(id = movieId))
        return list.crew
    }

    override suspend fun getMovieTrailer(movieId: Int): List<Result> {
        return trailerMapper.toGetTrailerModel(api.getTrailer(id = movieId)).results
    }

    override suspend fun getSimilarMovie(movieId: Int): MovieDetail {
       val list = api.getSimilarMovies(id = movieId)
        return movieDetailMapper.toGetMovieDetailModel(list)
    }

    override suspend fun getRecommendMovie(movieId: Int): MovieDetail {
        val list = api.getRecommendationsMovies(id = movieId)
        return movieDetailMapper.toGetMovieDetailModel(list)
    }
}