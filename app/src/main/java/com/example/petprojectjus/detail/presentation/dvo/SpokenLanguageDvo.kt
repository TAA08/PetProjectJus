package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpokenLanguageDvo(
    val englishName: String,
    val iso_639_1: String,
    val name: String
) : Parcelable