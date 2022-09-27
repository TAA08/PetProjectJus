package com.example.petprojectjus.detail.presentation.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastCrewDvo(
    val castDvo: List<CastDvo>,
    val crewDvo: List<CrewDvo>,
    val id: Int
) : Parcelable