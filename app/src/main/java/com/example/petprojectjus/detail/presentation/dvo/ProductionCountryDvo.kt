package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCountryDvo(
    val iso_3166_1: String,
    val name: String
) : Parcelable