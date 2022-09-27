package com.example.petprojectjus.detail.data.network.modelDTO


import com.google.gson.annotations.SerializedName

data class MovieResultResponse(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var movieResponses: List<MovieResponse>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)