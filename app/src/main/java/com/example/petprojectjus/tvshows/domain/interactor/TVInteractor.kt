package com.example.petprojectjus.tvshows.domain.interactor

import com.example.petprojectjus.tvshows.domain.repository.TvRepository

class TVInteractor(
    private val tvRepository: TvRepository
) {

    suspend fun getPopularTV(page: Int) = tvRepository.getPopularTV(page)

    suspend fun getTopRated(page: Int) = tvRepository.getTopRated(page)

    suspend fun getAiringToday(page: Int) = tvRepository.getAiringToday(page)

    suspend fun getTrendingTv(page: Int) = tvRepository.getTrendingTv(page)
}