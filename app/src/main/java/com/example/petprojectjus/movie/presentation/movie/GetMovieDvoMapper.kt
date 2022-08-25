package com.example.petprojectjus.movie.presentation.movie

import com.example.petprojectjus.movie.domain.model.GetMovieModel

class GetMovieDvoMapper {

    fun toGetMovieDvo(from: GetMovieModel) : GetMovieDvo{
        return GetMovieDvo(
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
}