package com.example.petprojectjus.celebrity.presentation

import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityDvo
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityType

sealed class State {
    object Error : State()
    object Loading : State()
    data class  CelebrityData(
        val celebrityList: List<CelebrityDvo>,
        val celebrityType: CelebrityType
    ) : State()
}