package com.example.petprojectjus.detail.data.network.modelDTO


import com.google.gson.annotations.SerializedName

data class SpokenLanguageResponse(
    @SerializedName("english_name")
    var englishName: String?,
    @SerializedName("iso_639_1")
    var iso6391: String?,
    @SerializedName("name")
    var name: String?
)