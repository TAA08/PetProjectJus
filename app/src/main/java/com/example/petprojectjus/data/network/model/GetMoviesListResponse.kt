package com.example.petprojectjus.data.network.model

import com.google.gson.annotations.SerializedName

data class GetMoviesListResponse (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val getMovieModels: List<GetMovieResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)