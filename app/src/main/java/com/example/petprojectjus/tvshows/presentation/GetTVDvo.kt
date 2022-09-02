package com.example.petprojectjus.tvshows.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetTVDvo(
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
) : Parcelable