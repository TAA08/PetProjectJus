package com.example.petprojectjus.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petprojectjus.domain.interactor.MovieInteractor
import com.example.petprojectjus.presentation.Data
import com.example.petprojectjus.presentation.State
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieInteractor: MovieInteractor,
    private val mapper: GetMovieDvoMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    private suspend fun getPopularMovieList() {
        viewModelScope.launch {
            val movieList = movieInteractor.getPopularMovieList(page = 1)
            _viewState.value = Data(movieList.map { mapper.toGetMovieDvo(it) })
        }
    }

    private suspend fun getUpcomingMovieList() {
        viewModelScope.launch {
            val movieList = movieInteractor.getUpcomingMovieList(page = 1)
            _viewState.value = Data(movieList.map { mapper.toGetMovieDvo(it) })
        }
    }

    private suspend fun getNowPlayingMovieList() {
        viewModelScope.launch {
            val movieList = movieInteractor.getNowPlayingMovies(page = 1)
            _viewState.value = Data(movieList.map { mapper.toGetMovieDvo(it) })
        }
    }

    private suspend fun getTopRatedMovieList() {
        viewModelScope.launch {
            val movieList = movieInteractor.getTopRatedMovieList(page = 1)
            _viewState.value = Data(movieList.map { mapper.toGetMovieDvo(it) })
        }
    }

    private suspend fun getTrendingMovieList() {
        viewModelScope.launch {
            val movieList = movieInteractor.getTrendingMovies(page = 1)
            _viewState.value = Data(movieList.map { mapper.toGetMovieDvo(it) })
        }
    }
}