package com.example.petprojectjus.movie.data.mapper

import com.example.petprojectjus.movie.data.network.modelDTO.GetMovieResponse
import com.example.petprojectjus.movie.data.network.modelDTO.GetMoviesListResponse
import com.example.petprojectjus.movie.domain.model.GetMovieModel
import com.example.petprojectjus.movie.domain.model.GetMoviesListModel

class MovieModelMapper {

    fun toGetMovieModel(from: GetMovieResponse): GetMovieModel {
        return GetMovieModel(
            adult = from.adult ?: false,
            backdropPath = from.backdropPath ?: "",
            genreIds = from.genreIds ?: emptyList(),
            id = from.id ?: -1,
            originalLanguage = from.originalLanguage ?: "",
            originalTitle = from.originalTitle ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: -1.0,
            posterPath = from.posterPath ?: "",
            releaseDate = from.releaseDate ?: "",
            title = from.title ?: "",
            video = from.video ?: false,
            voteAverage = from.voteAverage ?: -1.0,
            voteCount = from.voteCount ?: -1
        )
    }

    fun toGetMoviesListModel(from: GetMoviesListResponse): GetMoviesListModel {
        return GetMoviesListModel(
            page = from.page ?: -1,
            getMovieModels = from.getMovieModels?.map { toGetMovieModel(it) } ?: emptyList(),
            totalPages = from.totalPages ?: -1,
            totalResults = from.totalResults ?: -1
        )
    }
}