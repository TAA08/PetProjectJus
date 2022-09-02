package com.example.petprojectjus.tvshows.data.mapper

import com.example.petprojectjus.tvshows.data.network.Dto.GetTVResponse
import com.example.petprojectjus.tvshows.domain.model.GetTV

class TVModelMapper {

    fun toGetTVModel(from: GetTVResponse): GetTV {
        return GetTV(
            backdropPath = from.backdropPath ?: "",
            firstAirDate = from.firstAirDate ?: "",
            genreIds = from.genreIds ?: emptyList(),
            id = from.id ?: -1,
            name = from.name ?: "",
            originCountry = from.originCountry ?: emptyList(),
            originalLanguage = from.originalLanguage ?: "",
            originalName = from.originalName ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: -1.0,
            posterPath = from.posterPath ?: "",
            voteAverage = from.voteAverage ?: -1.0,
            voteCount = from.voteCount ?: -1,
            adult = from.adult?: false
        )
    }
}