package com.example.petprojectjus.tvshows.data.network.Dto


import com.google.gson.annotations.SerializedName

data class GetTVListResponse(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var getTVResponses: List<GetTVResponse>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)