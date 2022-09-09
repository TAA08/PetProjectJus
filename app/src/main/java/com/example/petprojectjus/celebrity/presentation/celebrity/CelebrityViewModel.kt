package com.example.petprojectjus.celebrity.presentation.celebrity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petprojectjus.celebrity.domain.interactor.CelebrityInteractor
import com.example.petprojectjus.celebrity.presentation.State
import kotlinx.coroutines.launch

class CelebrityViewModel(
    val celebrityInteractor: CelebrityInteractor,
    val mapper: CelebrityDvoMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    fun getCelebrity(celebrityType: CelebrityType) {
        when (celebrityType) {
            CelebrityType.POPULAR -> getPopularCelebrity()
            CelebrityType.TRENDING -> getTrendingCelebrity()
        }
    }

    private fun getTrendingCelebrity() {
        viewModelScope.launch {
            val list = celebrityInteractor.getTrendingCelebrity()
            _viewState.value = State.CelebrityData(
                list.map { mapper.toGetCelebrityModel(it) },
                CelebrityType.TRENDING
            )
        }
    }

    private fun getPopularCelebrity() {
        viewModelScope.launch {
            val list = celebrityInteractor.getPopularCelebrity()
            _viewState.value = State.CelebrityData(
                list.map { mapper.toGetCelebrityModel(it) },
                CelebrityType.POPULAR
            )
        }
    }
}