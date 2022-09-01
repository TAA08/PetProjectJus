package com.example.petprojectjus.tvshows.data.mapper

import com.example.petprojectjus.tvshows.data.network.Dto.GetTVResponse
import com.example.petprojectjus.tvshows.domain.model.GetTV

class TVModelMapper {

    fun toGetTVModel(from: GetTVResponse): GetTV {
        return GetTV(
            backdrop_path = from.backdropPath ?: "",
            first_air_date = from.firstAirDate ?: "",
            genre_ids = from.genreIds ?: emptyList(),
            id = from.id ?: -1,
            name = from.name ?: "",
            origin_country = from.originCountry ?: emptyList(),
            original_language = from.originalLanguage ?: "",
            original_name = from.originalName ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: -1.0,
            poster_path = from.posterPath ?: "",
            vote_average = from.voteAverage ?: -1.0,
            vote_count = from.voteCount ?: -1
        )
    }
}