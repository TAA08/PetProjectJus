package com.example.petprojectjus.detail.domain.model

data class MovieResultModel(
    val page: Int,
    val results: List<MovieModel>,
    val totalPages: Int,
    val totalResults: Int
)