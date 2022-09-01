package com.example.petprojectjus.tvshows.domain.interactor

import com.example.petprojectjus.tvshows.domain.repository.TvRepository

class TVInteractor(
    private val tvRepository: TvRepository
) {

    fun getPopularTV(page: Int) = tvRepository.getPopularTV(page)

    fun getTopRated(page: Int) = tvRepository.getTopRated(page)

    fun getAiringToday(page: Int) = tvRepository.getAiringToday(page)

    fun getTrendingTv(page: Int) = tvRepository.getTrendingTv(page)
}