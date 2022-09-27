package com.example.petprojectjus.detail.presentation

import com.example.petprojectjus.detail.presentation.dvo.MovieDvo

sealed class State {
    object Error : State()
    object Loading : State()
    object Result : State()
    data class MovieType(
        val movieList: List<MovieDvo>,
        val movieDetailType: MovieDetailType
    ) : State()
}
