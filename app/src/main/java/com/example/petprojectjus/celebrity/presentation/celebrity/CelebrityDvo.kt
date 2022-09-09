package com.example.petprojectjus.celebrity.presentation.celebrity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CelebrityDvo(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownForDvo>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
) : Parcelable
