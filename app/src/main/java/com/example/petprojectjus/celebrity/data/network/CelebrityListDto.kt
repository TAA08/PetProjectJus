package com.example.petprojectjus.celebrity.data.network

import com.google.gson.annotations.SerializedName

data class CelebrityListDto(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var celebrityDto: List<CelebrityDto>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var total_results: Int?
)