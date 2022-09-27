package com.example.petprojectjus.detail.data.mapper

import com.example.petprojectjus.detail.data.network.modelDTO.CastCrewResponse
import com.example.petprojectjus.detail.data.network.modelDTO.CastResponse
import com.example.petprojectjus.detail.data.network.modelDTO.CrewResponse
import com.example.petprojectjus.detail.domain.model.Cast
import com.example.petprojectjus.detail.domain.model.CastCrew
import com.example.petprojectjus.detail.domain.model.Crew

class CastCrewMapper {

    fun toGetCastCrewModel(from: CastCrewResponse): CastCrew {
        return CastCrew(
            cast = from.castResponse?.map(::toGetCastModel).orEmpty(),
            crew = from.crewResponse?.map { toGetCrewModel(it) } ?: emptyList(),
            id = from.id ?: -1
        )
    }

    fun toGetCastModel(from: CastResponse?): Cast {
        return Cast(
            adult = from?.adult ?: false,
            castId = from?.castId ?: -1,
            character = from?.character ?: "",
            creditId = from?.creditId ?: "",
            gender = from?.gender ?: 0,
            id = from?.id ?: -1,
            knownForDepartment = from?.knownForDepartment ?: "",
            name = from?.name ?: "",
            order = from?.order ?: 0,
            originalName = from?.originalName ?: "",
            popularity = from?.popularity ?: 0.0,
            profilePath = from?.profilePath ?: ""
        )
    }

    fun toGetCrewModel(from: CrewResponse?): Crew {
        return Crew(
            adult = from?.adult ?: false,
            creditId = from?.creditId ?: "",
            department = from?.department ?: "",
            gender = from?.gender ?: 0,
            id = from?.id ?: 0,
            job = from?.job ?: "",
            knownForDepartment = from?.knownForDepartment ?: "",
            name = from?.name ?: "",
            originalName = from?.originalName ?: "",
            popularity = from?.popularity ?: 0.0,
            profilePath = from?.profilePath ?: ""
        )
    }
}