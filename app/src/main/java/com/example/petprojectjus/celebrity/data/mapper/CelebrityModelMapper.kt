package com.example.petprojectjus.celebrity.data.mapper

import com.example.petprojectjus.celebrity.data.network.CelebrityDto
import com.example.petprojectjus.celebrity.data.network.CelebrityInfoDto
import com.example.petprojectjus.celebrity.data.network.KnownForDto
import com.example.petprojectjus.celebrity.domain.model.Celebrity
import com.example.petprojectjus.celebrity.domain.model.CelebrityInfo
import com.example.petprojectjus.celebrity.domain.model.KnownFor

class CelebrityModelMapper {

    fun toGetCelebrityModel(from: CelebrityDto): Celebrity {
        return Celebrity(
            adult = from.adult ?: false,
            gender = from.gender ?: -1,
            id = from.id ?: -1,
            known_for = from.known_for?.map { toGetKnownForModel(it) }.orEmpty(),
            known_for_department = from.known_for_department.orEmpty(),
            name = from.name.orEmpty(),
            popularity = from.popularity ?: 0.0,
            profile_path = from.profile_path.orEmpty()
        )
    }

    fun toGetKnownForModel(from: KnownForDto): KnownFor {
        return KnownFor(
            adult = from.adult ?: false,
            backdrop_path = from.backdrop_path.orEmpty(),
            first_air_date = from.first_air_date.orEmpty(),
            genre_ids = from.genre_ids.orEmpty(),
            id = from.id ?: -1,
            media_type = from.media_type.orEmpty(),
            name = from.name.orEmpty(),
            origin_country = from.origin_country.orEmpty(),
            original_language = from.original_language.orEmpty(),
            original_name = from.original_name.orEmpty(),
            original_title = from.original_title.orEmpty(),
            overview = from.overview.orEmpty(),
            poster_path = from.poster_path.orEmpty(),
            release_date = from.release_date.orEmpty(),
            title = from.title.orEmpty(),
            video = from.video ?: false,
            vote_average = from.vote_average ?: -1.0,
            vote_count = from.vote_count ?: -1

        )
    }

    fun toGetCelebrityInfo(from: CelebrityInfoDto): CelebrityInfo {
        return CelebrityInfo(
            adult = from.adult ?: false,
            also_known_as = from.also_known_as.orEmpty(),
            biography = from.biography.orEmpty(),
            birthday = from.birthday.orEmpty(),
            deathday = from.deathday ?: 0,
            gender = from.gender ?: 0,
            homepage = from.homepage ?: 0,
            id = from.id ?: -1,
            imdb_id = from.imdb_id.orEmpty(),
            known_for_department = from.known_for_department.orEmpty(),
            name = from.name.orEmpty(),
            place_of_birth = from.place_of_birth.orEmpty(),
            popularity = from.popularity ?: 0.0,
            profile_path = from.profile_path.orEmpty()
        )
    }
}