package com.example.petprojectjus.tvshows.domain.model

data class GetTVList(
    val page: Int,
    val getTVS: List<GetTV>,
    val total_pages: Int,
    val total_results: Int
)