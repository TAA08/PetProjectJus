package com.example.petprojectjus.detail.presentation.mapper

import com.example.petprojectjus.detail.domain.model.Cast
import com.example.petprojectjus.detail.domain.model.CastCrew
import com.example.petprojectjus.detail.domain.model.Crew
import com.example.petprojectjus.detail.presentation.dvo.CastCrewDvo
import com.example.petprojectjus.detail.presentation.dvo.CastDvo
import com.example.petprojectjus.detail.presentation.dvo.CrewDvo

class CastCrewDvoMapper {

    fun toGetCastCrewModel(from: CastCrew): CastCrewDvo {
        return CastCrewDvo(
            castDvo = from.cast.map(::toGetCastModel),
            crewDvo = from.crew.map { toGetCrewModel(it) },
            id = from.id
        )
    }

    fun toGetCastModel(from: Cast): CastDvo {
        return CastDvo(
            adult = from.adult,
            castId = from.castId,
            character = from.character,
            creditId = from.creditId,
            gender = from.gender,
            id = from.id,
            knownForDepartment = from.knownForDepartment,
            name = from.name,
            order = from.order,
            originalName = from.originalName,
            popularity = from.popularity,
            profilePath = from.profilePath
        )
    }

    fun toGetCrewModel(from: Crew): CrewDvo {
        return CrewDvo(
            adult = from.adult,
            creditId = from.creditId,
            department = from.department,
            gender = from.gender,
            id = from.id,
            job = from.job,
            knownForDepartment = from.knownForDepartment,
            name = from.name,
            originalName = from.originalName,
            popularity = from.popularity,
            profilePath = from.profilePath
        )
    }
}