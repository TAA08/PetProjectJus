package com.example.petprojectjus.detail.presentation.mapper

import com.example.petprojectjus.detail.domain.model.Result
import com.example.petprojectjus.detail.domain.model.Trailer
import com.example.petprojectjus.detail.presentation.dvo.ResultDvo
import com.example.petprojectjus.detail.presentation.dvo.TrailerDvo

class TrailerDvoMapper {

    fun toGetTrailerModel(from: Trailer): TrailerDvo {
        return TrailerDvo(
            id = from.id,
            resultDvos = from.results.map { toGetTrailerResult(it) }
        )
    }

    fun toGetTrailerResult(from: Result?): ResultDvo {
        return ResultDvo(
            id = from?.id ?: "",
            iso_3166_1 = from?.iso_3166_1 ?: "",
            iso_639_1 = from?.iso_639_1 ?: "",
            key = from?.key ?: "",
            name = from?.name ?: "",
            official = from?.official ?: false,
            publishedAt = from?.publishedAt ?: "",
            site = from?.site ?: "",
            size = from?.size ?: 0,
            type = from?.type ?: ""
        )
    }
}