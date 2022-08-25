package com.example.petprojectjus.movie.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petprojectjus.movie.domain.interactor.MovieInteractor
import com.example.petprojectjus.movie.presentation.MovieData
import com.example.petprojectjus.movie.presentation.State
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieInteractor: MovieInteractor,
    private val mapper: GetMovieDvoMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    /**
     * выбор функции взамисимости от moviesType
     */
    fun getMovies(moviesType: MoviesType) {
        when (moviesType) {
            MoviesType.POPULAR -> getPopularMovieList()
            MoviesType.UPCOMING -> getUpcomingMovieList()
            MoviesType.PLAYING -> getNowPlayingMovieList()
            MoviesType.TOPRATED -> getTopRatedMovieList()
            MoviesType.TRENDING -> getTrendingMovieList()
        }
    }

    private fun getPopularMovieList() {
        viewModelScope.launch {
            val movieModelList = movieInteractor.getPopularMovieList(page = FIRST_PAGE)
            _viewState.value = MovieData(
                movieList = movieModelList.map { mapper.toGetMovieDvo(it) },
                type = MoviesType.POPULAR
            )
        }
    }

    private fun getUpcomingMovieList() {
        viewModelScope.launch {
            val movieModelList = movieInteractor.getUpcomingMovieList(page = FIRST_PAGE)
            _viewState.value = MovieData(
                movieList = movieModelList.map { mapper.toGetMovieDvo(it) },
                type = MoviesType.UPCOMING
            )
        }
    }

    private fun getNowPlayingMovieList() {
        viewModelScope.launch {
            val movieModelList = movieInteractor.getNowPlayingMovies(page = FIRST_PAGE)
            _viewState.value = MovieData(
                movieList = movieModelList.map { mapper.toGetMovieDvo(it) },
                type = MoviesType.PLAYING
            )
        }
    }

    private fun getTopRatedMovieList() = viewModelScope.launch {
        val movieModelList = movieInteractor.getTopRatedMovieList(page = FIRST_PAGE)
        _viewState.value = MovieData(
            movieList = movieModelList.map { mapper.toGetMovieDvo(it) },
            type = MoviesType.TOPRATED
        )
    }

    private fun getTrendingMovieList() {
        viewModelScope.launch {
            val movieModelList = movieInteractor.getTrendingMovies(page = FIRST_PAGE)
            _viewState.value = MovieData(
                movieList = movieModelList.map { mapper.toGetMovieDvo(it) },
                type = MoviesType.TRENDING
            )
        }
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}