package com.example.petprojectjus.data.mapper

import com.example.petprojectjus.data.network.model.GetMovieResponse
import com.example.petprojectjus.data.network.model.GetMoviesListResponse
import com.example.petprojectjus.domain.model.GetMovieModel
import com.example.petprojectjus.domain.model.GetMoviesListModel

class MovieModelMapper {

    fun toGetMovieModel(from: GetMovieResponse): GetMovieModel {
        return GetMovieModel(
            adult = from.adult,
            backdropPath = from.backdropPath,
            genreIds = from.genreIds,
            id = from.id,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            overview = from.overview,
            popularity = from.popularity,
            posterPath = from.posterPath,
            releaseDate = from.releaseDate,
            title = from.title,
            video = from.video,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount
        )
    }

    fun toGetMoviesListModel(from: GetMoviesListResponse): GetMoviesListModel {
        return GetMoviesListModel(
            page = from.page,
            getMovieModels = from.getMovieModels.map { toGetMovieModel(it) },
            totalPages = from.totalPages,
            totalResults = from.totalResults
        )
    }
}