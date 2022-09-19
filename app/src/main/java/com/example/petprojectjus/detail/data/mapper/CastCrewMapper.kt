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
            cast = from.castResponse?.map { toGetCastModel(it) } ?: emptyList(),
            crew = from.crewResponse?.map { toGetCrewModel(it) } ?: emptyList(),
            id = from.id ?: -1
        )
    }

    fun toGetCastModel(from: CastResponse?): Cast {
        return Cast(
            adult = from?.adult ?: false,
            cast_id = from?.castId ?: -1,
            character = from?.character ?: "",
            credit_id = from?.creditId ?: "",
            gender = from?.gender ?: 0,
            id = from?.id ?: -1,
            known_for_department = from?.knownForDepartment ?: "",
            name = from?.name ?: "",
            order = from?.order ?: 0,
            original_name = from?.originalName ?: "",
            popularity = from?.popularity ?: 0.0,
            profile_path = from?.profilePath ?: ""
        )
    }

    fun toGetCrewModel(from: CrewResponse?): Crew {
        return Crew(
            adult = from?.adult ?: false,
            credit_id = from?.creditId ?: "",
            department = from?.department ?: "",
            gender = from?.gender ?: 0,
            id = from?.id ?: 0,
            job = from?.job ?: "",
            known_for_department = from?.knownForDepartment ?: "",
            name = from?.name ?: "",
            original_name = from?.originalName ?: "",
            popularity = from?.popularity ?: 0.0,
            profile_path = from?.profilePath ?: ""
        )
    }
}