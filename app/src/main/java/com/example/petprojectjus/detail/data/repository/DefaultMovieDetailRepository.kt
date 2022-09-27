package com.example.petprojectjus.detail.data.repository

import com.example.petprojectjus.detail.data.mapper.CastCrewMapper
import com.example.petprojectjus.detail.data.mapper.MovieDetailMapper
import com.example.petprojectjus.detail.data.mapper.TrailerMapper
import com.example.petprojectjus.detail.data.network.MovieDetailService
import com.example.petprojectjus.detail.domain.model.CastCrew
import com.example.petprojectjus.detail.domain.model.MovieDetail
import com.example.petprojectjus.detail.domain.model.MovieModel
import com.example.petprojectjus.detail.domain.model.Trailer
import com.example.petprojectjus.detail.domain.repository.MovieDetailRepository

class DefaultMovieDetailRepository(
    val api: MovieDetailService,
    val movieDetailMapper: MovieDetailMapper,
    val crewMapper: CastCrewMapper,
    val trailerMapper: TrailerMapper
) : MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        val list = api.getMovieDetail(id = movieId)
        return movieDetailMapper.toGetMovieDetailModel(list)
    }

    override suspend fun getMovieTrailer(movieId: Int): Trailer {
        return trailerMapper.toGetTrailerModel(api.getTrailer(id = movieId))
    }

    override suspend fun getCastCrew(movieId: Int): CastCrew {
        return crewMapper.toGetCastCrewModel(api.getCastCrew(id = movieId))
    }

    override suspend fun getSimilarMovie(movieId: Int): List<MovieModel> {
        val list = api.getSimilarMovies(id = movieId).movieResponses
        return list?.map { movieDetailMapper.toGetMovieModel(it) } ?: emptyList()
    }

    override suspend fun getRecommendMovie(movieId: Int): List<MovieModel> {
        val list = api.getRecommendationsMovies(id = movieId).movieResponses
        return list?.map { movieDetailMapper.toGetMovieModel(it) } ?: emptyList()
    }
}