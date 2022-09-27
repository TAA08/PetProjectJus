package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BelongsToCollectionDvo(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val posterPath: String
) : Parcelable