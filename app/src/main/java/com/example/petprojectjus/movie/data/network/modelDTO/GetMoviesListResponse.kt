package com.example.petprojectjus.movie.data.network.modelDTO

import com.google.gson.annotations.SerializedName

data class GetMoviesListResponse (
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var getMovieModels: List<GetMovieResponse>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)