package com.example.petprojectjus.movie.domain.model

data class GetMoviesListModel(
    val page: Int,
    val getMovieModels: List<GetMovieModel>,
    val totalPages: Int,
    val totalResults: Int
)