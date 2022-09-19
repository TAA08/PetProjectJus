package com.example.petprojectjus.detail.data.mapper

import com.example.petprojectjus.detail.data.network.modelDTO.ResultResponse
import com.example.petprojectjus.detail.data.network.modelDTO.TrailerResponse
import com.example.petprojectjus.detail.domain.model.Result
import com.example.petprojectjus.detail.domain.model.Trailer

class TrailerMapper {

    fun toGetTrailerModel(from: TrailerResponse): Trailer {
        return Trailer(
            id = from.id ?: 0,
            results = from.resultResponses?.map { toGetTrailerResult(it) } ?: emptyList()
        )
    }

    fun toGetTrailerResult(from: ResultResponse?): Result {
        return Result(
            id = from?.id ?: "",
            iso_3166_1 = from?.iso31661 ?: "",
            iso_639_1 = from?.iso6391 ?: "",
            key = from?.key ?: "",
            name = from?.name ?: "",
            official = from?.official ?: false,
            published_at = from?.publishedAt ?: "",
            site = from?.site ?: "",
            size = from?.size ?: 0,
            type = from?.type ?: ""
        )
    }
}