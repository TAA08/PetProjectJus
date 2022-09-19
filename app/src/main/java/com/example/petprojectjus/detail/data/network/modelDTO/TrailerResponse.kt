package com.example.petprojectjus.detail.data.network.modelDTO


import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("results")
    var resultResponses: List<ResultResponse?>?
)