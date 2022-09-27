package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenreDvo(
    val id: Int,
    val name: String
) : Parcelable