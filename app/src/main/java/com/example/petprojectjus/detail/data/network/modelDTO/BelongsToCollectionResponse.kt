package com.example.petprojectjus.detail.data.network.modelDTO


import com.google.gson.annotations.SerializedName

data class BelongsToCollectionResponse(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("poster_path")
    var posterPath: String?
)