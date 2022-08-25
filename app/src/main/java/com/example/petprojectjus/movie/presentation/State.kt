package com.example.petprojectjus.movie.presentation

import com.example.petprojectjus.movie.presentation.movie.GetMovieDvo
import com.example.petprojectjus.movie.presentation.movie.MoviesType

sealed class State

object Error : State()

object Progress : State()

data class MovieData(
    val movieList: List<GetMovieDvo>,
    val type: MoviesType? = null
) : State()