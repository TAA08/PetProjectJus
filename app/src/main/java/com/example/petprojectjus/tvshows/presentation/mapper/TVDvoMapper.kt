package com.example.petprojectjus.tvshows.presentation.mapper

import com.example.petprojectjus.tvshows.domain.model.GetTV
import com.example.petprojectjus.tvshows.presentation.GetTVDvo

class TVDvoMapper {

    fun toGetTVDvo(from: GetTV): GetTVDvo {
        return GetTVDvo(
            backdropPath = from.backdropPath,
            firstAirDate = from.firstAirDate,
            genreIds = from.genreIds,
            id = from.id,
            name = from.name,
            originCountry = from.originCountry,
            originalLanguage = from.originalLanguage,
            originalName = from.originalName,
            overview = from.overview,
            popularity = from.popularity,
            posterPath = from.posterPath,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount
        )
    }
}