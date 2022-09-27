package com.example.petprojectjus.detail.presentation.dvo

data class MovieResultDvo(
    val page: Int,
    val results: List<MovieDvo>,
    val totalPages: Int,
    val totalResults: Int
)