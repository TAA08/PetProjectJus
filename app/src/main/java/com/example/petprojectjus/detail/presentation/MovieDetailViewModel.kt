package com.example.petprojectjus.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petprojectjus.detail.domain.interactor.MovieDetailInteractor
import com.example.petprojectjus.detail.presentation.dvo.CastDvo
import com.example.petprojectjus.detail.presentation.dvo.CrewDvo
import com.example.petprojectjus.detail.presentation.dvo.MovieDetailDvo
import com.example.petprojectjus.detail.presentation.dvo.ResultDvo
import com.example.petprojectjus.detail.presentation.mapper.CastCrewDvoMapper
import com.example.petprojectjus.detail.presentation.mapper.MovieDetailDvoMapper
import com.example.petprojectjus.detail.presentation.mapper.TrailerDvoMapper
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieDetailInteractor: MovieDetailInteractor,
    private val castCrewDvoMapper: CastCrewDvoMapper,
    private val movieDetailDvoMapper: MovieDetailDvoMapper,
    private val trailerDvoMapper: TrailerDvoMapper
) : ViewModel() {


    private val _movieDetail = MutableLiveData<MovieDetailDvo>()
    val movieDetail: LiveData<MovieDetailDvo>
        get() = _movieDetail

    private val _trailer = MutableLiveData<List<ResultDvo>>()
    val trailer: LiveData<List<ResultDvo>>
        get() = _trailer

    private val _cast = MutableLiveData<List<CastDvo>>()
    val cast: LiveData<List<CastDvo>>
        get() = _cast

    private val _crew = MutableLiveData<List<CrewDvo>>()
    val crew: LiveData<List<CrewDvo>>
        get() = _crew

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    fun getMovieById(movieId: Int) {
        getMovieDetail(movieId)


        getMovieCast(movieId)
        getMovieCrew(movieId)
        getMovieVideo(movieId)
    }

    fun getMovieType(movieId: Int, movieDetailType: MovieDetailType) {
        when (movieDetailType) {
            MovieDetailType.RECOMMENDATION -> getRecommendationMovie(movieId)
            MovieDetailType.SIMILAR -> getSimilarMovie(movieId)
        }
    }

    private fun getSimilarMovie(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            val list = movieDetailInteractor.getSimilarMovie(movieId)
                .map { movieDetailDvoMapper.toGetMovieDvo(it) }
            _viewState.value = State.MovieType(
                movieList = list,
                movieDetailType = MovieDetailType.SIMILAR
            )
            _viewState.value = State.Result
        }
    }

    private fun getRecommendationMovie(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            val list = movieDetailInteractor.getRecommendMovie(movieId)
                .map { movieDetailDvoMapper.toGetMovieDvo(it) }
            _viewState.value = State.MovieType(
                movieList = list,
                movieDetailType = MovieDetailType.RECOMMENDATION
            )
            _viewState.value = State.Result
        }
    }

    private fun getMovieCast(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            val movieCast = movieDetailInteractor.getCastCrew(movieId).cast
            _cast.value = movieCast.map { castCrewDvoMapper.toGetCastModel(it) }
        }
        _viewState.value = State.Result
    }

    private fun getMovieCrew(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            val movieCrew = movieDetailInteractor.getCastCrew(movieId).crew
            _crew.value = movieCrew.map { castCrewDvoMapper.toGetCrewModel(it) }
        }
        _viewState.value = State.Result
    }

    private fun getMovieVideo(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            _trailer.value =
                trailerDvoMapper.toGetTrailerModel(movieDetailInteractor.getMovieTrailer(movieId)).resultDvos
            _viewState.value = State.Result

        }
    }

    private fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _viewState.value = State.Loading
            _movieDetail.value = movieDetailDvoMapper.toGetMovieDetailDvoModel(
                movieDetailInteractor.getMovieDetail(movieId)
            )
            _viewState.value = State.Result
        }
    }
}