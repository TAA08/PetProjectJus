package com.example.petprojectjus.detail.data.mapper

import com.example.petprojectjus.detail.data.network.modelDTO.*
import com.example.petprojectjus.detail.domain.model.*

class MovieDetailMapper {
    fun toGetMovieDetailModel(from: MovieDetailResponse): MovieDetail {
        return MovieDetail(
            adult = from.adult ?: false,
            backdrop_path = from.backdropPath ?: "",
            belongs_to_collection = toGetBelongCollectionModel(from.belongsToCollectionResponse),
            budget = from.budget ?: -1,
            genres = from.genreResponses?.map { toGetGenre(it) } ?: emptyList(),
            homepage = from.homepage ?: "",
            id = from.id ?: -1,
            imdb_id = from.imdbId ?: "",
            original_language = from.originalLanguage ?: "",
            original_title = from.originalTitle ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: 0.0,
            poster_path = from.posterPath ?: "",
            production_companies = from.productionCompanies?.map { toGetProductionCompanies(it) }
                ?: emptyList(),
            production_countries = from.productionCountries?.map { toGetProductionCountry(it) }
                ?: emptyList(),
            release_date = from.releaseDate ?: "",
            revenue = from.revenue ?: -1,
            runtime = from.runtime ?: 0,
            spoken_languages = from.spokenLanguageResponses?.map { toGetLanguage(it) }
                ?: emptyList(),
            status = from.status ?: "",
            tagline = from.tagline ?: "",
            title = from.title ?: "",
            video = from.video ?: false,
            vote_average = from.voteAverage ?: 0.0,
            vote_count = from.voteCount ?: 0
        )
    }

    private fun toGetBelongCollectionModel(from: BelongsToCollectionResponse?): BelongsToCollection {
        return BelongsToCollection(
            backdrop_path = from?.backdropPath ?: "",
            id = from?.id ?: -1,
            name = from?.name ?: "",
            poster_path = from?.posterPath ?: ""
        )
    }

    private fun toGetGenre(from: GenreResponse?): Genre {
        return Genre(
            id = from?.id ?: -1,
            name = from?.name ?: ""
        )
    }

    private fun toGetLanguage(from: SpokenLanguageResponse?): SpokenLanguage {
        return SpokenLanguage(
            english_name = from?.englishName ?: "",
            iso_639_1 = from?.iso6391 ?: "",
            name = from?.name ?: ""
        )
    }

    private fun toGetProductionCompanies(from: ProductionCompanyResponse?): ProductionCompany {
        return ProductionCompany(
            id = from?.id ?: -1,
            logo_path = from?.logoPath ?: "",
            name = from?.name ?: "",
            origin_country = from?.originCountry ?: ""
        )
    }

    private fun toGetProductionCountry(from: ProductionCountryResponse?): ProductionCountry {
        return ProductionCountry(
            iso_3166_1 = from?.iso31661 ?: "",
            name = from?.name ?: ""
        )
    }
}