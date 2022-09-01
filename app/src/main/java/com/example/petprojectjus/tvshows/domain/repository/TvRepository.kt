package com.example.petprojectjus.tvshows.domain.repository

import com.example.petprojectjus.tvshows.domain.model.GetTV

interface TvRepository {

    fun getPopularTV(page: Int): List<GetTV>

    fun getTopRated(page: Int): List<GetTV>

    fun getAiringToday(page: Int): List<GetTV>

    fun getTrendingTv(page: Int): List<GetTV>
}