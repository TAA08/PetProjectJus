package com.example.petprojectjus.celebrity.domain.model

data class CelebrityList(
    val page: Int,
    val celebrities: List<Celebrity>,
    val total_pages: Int,
    val total_results: Int
)