package com.example.petprojectjus.celebrity.presentation.celebrity

import com.example.petprojectjus.celebrity.domain.model.Celebrity
import com.example.petprojectjus.celebrity.domain.model.CelebrityInfo
import com.example.petprojectjus.celebrity.domain.model.KnownFor

class CelebrityDvoMapper {

    fun toGetCelebrityModel(from: Celebrity): CelebrityDvo {
        return CelebrityDvo(
            adult = from.adult,
            gender = from.gender,
            id = from.id,
            known_for = from.known_for.map { toGetKnownForModel(it) },
            known_for_department = from.known_for_department,
            name = from.name,
            popularity = from.popularity,
            profile_path = from.profile_path
        )
    }

    fun toGetKnownForModel(from: KnownFor): KnownForDvo {
        return KnownForDvo(
            adult = from.adult,
            backdrop_path = from.backdrop_path,
            first_air_date = from.first_air_date,
            genre_ids = from.genre_ids,
            id = from.id,
            media_type = from.media_type,
            name = from.name,
            origin_country = from.origin_country,
            original_language = from.original_language,
            original_name = from.original_name,
            original_title = from.original_title,
            overview = from.overview,
            poster_path = from.poster_path,
            release_date = from.release_date,
            title = from.title,
            video = from.video,
            vote_average = from.vote_average,
            vote_count = from.vote_count

        )
    }

    fun toGetCelebrityInfo(from: CelebrityInfo): CelebrityInfoDvo {
        return CelebrityInfoDvo(
            adult = from.adult,
            also_known_as = from.also_known_as,
            biography = from.biography,
            birthday = from.birthday,
            deathday = from.deathday,
            gender = from.gender,
            homepage = from.homepage,
            id = from.id,
            imdb_id = from.imdb_id,
            known_for_department = from.known_for_department,
            name = from.name,
            place_of_birth = from.place_of_birth,
            popularity = from.popularity,
            profile_path = from.profile_path
        )
    }
}