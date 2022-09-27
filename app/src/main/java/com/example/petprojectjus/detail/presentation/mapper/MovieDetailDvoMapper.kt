package com.example.petprojectjus.detail.presentation.mapper

import com.example.petprojectjus.detail.domain.model.*
import com.example.petprojectjus.detail.presentation.dvo.*

class MovieDetailDvoMapper {
    fun toGetMovieDetailDvoModel(from: MovieDetail): MovieDetailDvo {
        return MovieDetailDvo(
            adult = from.adult,
            backdropPath = from.backdropPath,
            belongsToCollection = toGetBelongCollectionModel(from.belongsToCollection),
            budget = from.budget,
            genreDvos = from.genres.map { toGetGenre(it) },
            homepage = from.homepage,
            id = from.id,
            imdbId = from.imdbId,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            overview = from.overview,
            popularity = from.popularity,
            posterPath = from.posterPath,
            productionCompanies = from.productionCompanies.map(::toGetProductionCompanies),
            productionCountries = from.productionCountries.map { toGetProductionCountry(it) },
            releaseDate = from.releaseDate,
            revenue = from.revenue,
            runtime = from.runtime,
            spokenLanguages = from.spokenLanguages.map(::toGetLanguage),
            status = from.status,
            tagline = from.tagline,
            title = from.title,
            video = from.video,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount
        )
    }

    private fun toGetBelongCollectionModel(from: BelongsToCollection?): BelongsToCollectionDvo {
        return BelongsToCollectionDvo(
            backdropPath = from?.backdropPath ?: "",
            id = from?.id ?: -1,
            name = from?.name ?: "",
            posterPath = from?.posterPath ?: ""
        )
    }

    private fun toGetGenre(from: Genre?): GenreDvo {
        return GenreDvo(
            id = from?.id ?: -1,
            name = from?.name ?: ""
        )
    }

    private fun toGetLanguage(from: SpokenLanguage?): SpokenLanguageDvo {
        return SpokenLanguageDvo(
            englishName = from?.englishName ?: "",
            iso_639_1 = from?.iso_639_1 ?: "",
            name = from?.name ?: ""
        )
    }

    private fun toGetProductionCompanies(from: ProductionCompany?): ProductionCompanyDvo {
        return ProductionCompanyDvo(
            id = from?.id ?: -1,
            logoPath = from?.logoPath ?: "",
            name = from?.name ?: "",
            originCountry = from?.originCountry ?: ""
        )
    }

    private fun toGetProductionCountry(from: ProductionCountry?): ProductionCountryDvo {
        return ProductionCountryDvo(
            iso_3166_1 = from?.iso_3166_1 ?: "",
            name = from?.name ?: ""
        )
    }

    fun toGetMovieDvo(from: MovieModel): MovieDvo {
        return MovieDvo(
            adult = from.adult,
            backdropPath = from.backdropPath,
            genreIds = from.genreIds,
            id = from.id,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            overview = from.overview,
            popularity = from.popularity,
            posterPath = from.posterPath,
            releaseDate = from.releaseDate,
            title = from.title,
            video = from.video,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount
        )
    }
}