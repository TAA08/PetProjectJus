package com.example.petprojectjus.tvshows.domain.repository

import com.example.petprojectjus.tvshows.domain.model.GetTV

interface TvRepository {

    suspend fun getPopularTV(page: Int): List<GetTV>

    suspend fun getTopRated(page: Int): List<GetTV>

    suspend fun getAiringToday(page: Int): List<GetTV>

    suspend fun getTrendingTv(page: Int): List<GetTV>
}