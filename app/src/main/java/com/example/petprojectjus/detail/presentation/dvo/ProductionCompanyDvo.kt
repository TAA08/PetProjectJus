package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompanyDvo(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
) : Parcelable