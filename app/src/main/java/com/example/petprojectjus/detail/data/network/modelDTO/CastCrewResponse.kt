package com.example.petprojectjus.detail.data.network.modelDTO


import com.google.gson.annotations.SerializedName

data class CastCrewResponse(
    @SerializedName("cast")
    var castResponse: List<CastResponse?>?,
    @SerializedName("crew")
    var crewResponse: List<CrewResponse?>?,
    @SerializedName("id")
    var id: Int?
)