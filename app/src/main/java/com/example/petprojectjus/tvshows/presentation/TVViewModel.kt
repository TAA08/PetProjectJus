package com.example.petprojectjus.tvshows.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.petprojectjus.tvshows.domain.interactor.TVInteractor
import com.example.petprojectjus.tvshows.presentation.mapper.TVDvoMapper
import kotlinx.coroutines.launch

class TVViewModel(
    private val tvInteractor: TVInteractor,
    private val mapper: TVDvoMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    fun getTVType(tvType: TVType) {
        when (tvType) {
            TVType.POPULAR -> getPopularTV()
            TVType.TOP_RATED -> getTopRatedTV()
            TVType.TRENDING -> getTrendingTV()
            TVType.AIRING_TODAY -> getAiringTodayTV()
        }
    }

    private fun getPopularTV() {
        viewModelScope.launch {
            val tvList = tvInteractor.getPopularTV(PAGE)
            _viewState.value = State.TVData(
                tvList = tvList.map { mapper.toGetTVDvo(it) },
                type = TVType.POPULAR
            )
        }
    }

    private fun getTopRatedTV() {
        viewModelScope.launch {
            val tvList = tvInteractor.getTopRated(PAGE)
            _viewState.value = State.TVData(
                tvList = tvList.map { mapper.toGetTVDvo(it) },
                type = TVType.TOP_RATED
            )
        }
    }

    private fun getTrendingTV() {
        viewModelScope.launch {
            val tvList = tvInteractor.getTrendingTv(PAGE)
            _viewState.value = State.TVData(
                tvList = tvList.map { mapper.toGetTVDvo(it) },
                type = TVType.TRENDING
            )
        }
    }

    private fun getAiringTodayTV() {
        viewModelScope.launch {
            val tvList = tvInteractor.getAiringToday(PAGE)
            _viewState.value = State.TVData(
                tvList = tvList.map { mapper.toGetTVDvo(it) },
                type = TVType.AIRING_TODAY
            )
        }
    }

    companion object {
        const val PAGE = 1
    }
}