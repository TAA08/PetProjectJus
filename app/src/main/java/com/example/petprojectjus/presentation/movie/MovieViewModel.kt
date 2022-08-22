package com.example.petprojectjus.presentation.movie

import androidx.lifecycle.ViewModel
import com.example.petprojectjus.domain.interactor.MovieInteractor

class MovieViewModel(
    private val movieInteractor: MovieInteractor
) : ViewModel() {
}