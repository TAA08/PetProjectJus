package com.example.petprojectjus.detail.data.mapper

import com.example.petprojectjus.detail.data.network.modelDTO.*
import com.example.petprojectjus.detail.domain.model.*

class MovieDetailMapper {
    fun toGetMovieDetailModel(from: MovieDetailResponse): MovieDetail {
        return MovieDetail(
            adult = from.adult ?: false,
            backdropPath = from.backdropPath ?: "",
            belongsToCollection = toGetBelongCollectionModel(from.belongsToCollectionResponse),
            budget = from.budget ?: -1,
            genres = from.genreResponses?.map { toGetGenre(it) } ?: emptyList(),
            homepage = from.homepage ?: "",
            id = from.id ?: -1,
            imdbId = from.imdbId ?: "",
            originalLanguage = from.originalLanguage ?: "",
            originalTitle = from.originalTitle ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: 0.0,
            posterPath = from.posterPath ?: "",
            productionCompanies = from.productionCompanies?.map(::toGetProductionCompanies)
                .orEmpty(),
            productionCountries = from.productionCountries?.map { toGetProductionCountry(it) }
                ?: emptyList(),
            releaseDate = from.releaseDate ?: "",
            revenue = from.revenue ?: -1,
            runtime = from.runtime ?: 0,
            spokenLanguages = from.spokenLanguageResponses?.map(::toGetLanguage) ?: emptyList(),
            status = from.status ?: "",
            tagline = from.tagline ?: "",
            title = from.title ?: "",
            video = from.video ?: false,
            voteAverage = from.voteAverage ?: 0.0,
            voteCount = from.voteCount ?: 0
        )
    }

    private fun toGetBelongCollectionModel(from: BelongsToCollectionResponse?): BelongsToCollection {
        return BelongsToCollection(
            backdropPath = from?.backdropPath ?: "",
            id = from?.id ?: -1,
            name = from?.name ?: "",
            posterPath = from?.posterPath ?: ""
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
            englishName = from?.englishName ?: "",
            iso_639_1 = from?.iso6391 ?: "",
            name = from?.name ?: ""
        )
    }

    private fun toGetProductionCompanies(from: ProductionCompanyResponse?): ProductionCompany {
        return ProductionCompany(
            id = from?.id ?: -1,
            logoPath = from?.logoPath ?: "",
            name = from?.name ?: "",
            originCountry = from?.originCountry ?: ""
        )
    }

    private fun toGetProductionCountry(from: ProductionCountryResponse?): ProductionCountry {
        return ProductionCountry(
            iso_3166_1 = from?.iso31661 ?: "",
            name = from?.name ?: ""
        )
    }

     fun toGetMovieModel(from: MovieResponse): MovieModel{
        return MovieModel(
            adult = from.adult ?: false,
            backdropPath = from.backdropPath ?: "",
            genreIds = from.genreIds ?: emptyList(),
            id = from.id ?: 0,
            originalLanguage = from.originalLanguage ?: "",
            originalTitle = from.originalTitle ?: "",
            overview = from.overview ?: "",
            popularity = from.popularity ?: 0.0,
            posterPath = from.posterPath ?: "",
            releaseDate = from.releaseDate ?: "",
            title = from.title ?: "",
            video = from.video ?: false,
            voteAverage = from.voteAverage ?: 0.0,
            voteCount = from.voteCount ?: -1
        )
    }
}