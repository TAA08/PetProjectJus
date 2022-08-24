package com.example.petprojectjus.presentation

import com.example.petprojectjus.presentation.movie.GetMovieDvo

sealed class State

object Error : State()

object Progress : State()

data class Data(
    val movieList: List<GetMovieDvo>
) : State()