package com.example.petprojectjus.celebrity.data.mapper

import com.example.petprojectjus.celebrity.data.network.CelebrityDto
import com.example.petprojectjus.celebrity.data.network.CelebrityInfoDto
import com.example.petprojectjus.celebrity.data.network.CelebrityListDto
import com.example.petprojectjus.celebrity.data.network.KnownForDto
import com.example.petprojectjus.celebrity.domain.model.Celebrity
import com.example.petprojectjus.celebrity.domain.model.CelebrityInfo
import com.example.petprojectjus.celebrity.domain.model.CelebrityList
import com.example.petprojectjus.celebrity.domain.model.KnownFor

class CelebrityModelMapper {

    fun toGetCelebrityModel(from: CelebrityDto): Celebrity {
        return Celebrity(
            adult = from.adult ?: false,
            gender = from.gender ?: -1,
            id = from.id ?: -1,
            known_for = from.knownFor?.map { toGetKnownForModel(it) }.orEmpty(),
            known_for_department = from.knownForDepartment.orEmpty(),
            name = from.name.orEmpty(),
            popularity = from.popularity ?: 0.0,
            profile_path = from.profilePath.orEmpty()
        )
    }

    fun toGetCelebrityListModel(from: CelebrityListDto): CelebrityList {
        return CelebrityList(
            page = from.page ?: -1,
            celebrities = from.celebrityDto?.map { toGetCelebrityModel(it) }.orEmpty(),
            total_pages = from.totalPages ?: -1,
            total_results = from.total_results ?: -1

        )
    }

    fun toGetKnownForModel(from: KnownForDto): KnownFor {
        return KnownFor(
            adult = from.adult ?: false,
            backdrop_path = from.backdropPath.orEmpty(),
            first_air_date = from.firstAirDate.orEmpty(),
            genre_ids = from.genreIds.orEmpty(),
            id = from.id ?: -1,
            media_type = from.mediaType.orEmpty(),
            name = from.name.orEmpty(),
            origin_country = from.originCountry.orEmpty(),
            original_language = from.originalLanguage.orEmpty(),
            original_name = from.originalName.orEmpty(),
            original_title = from.originalTitle.orEmpty(),
            overview = from.overview.orEmpty(),
            poster_path = from.posterPath.orEmpty(),
            release_date = from.releaseDate.orEmpty(),
            title = from.title.orEmpty(),
            video = from.video ?: false,
            vote_average = from.voteAverage ?: -1.0,
            vote_count = from.voteCount ?: -1

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