package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailDvo(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollectionDvo?,
    val budget: Int,
    val genreDvos: List<GenreDvo>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDvo>,
    val productionCountries: List<ProductionCountryDvo>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDvo>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Parcelable