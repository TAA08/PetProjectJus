package com.example.petprojectjus.tvshows.presentation

sealed class State{
    object Error : State()
    object Progress : State()
    data class TVData(
        val tvList: List<GetTVDvo>,
        var type : TVType? = null
    ) : State()
}


