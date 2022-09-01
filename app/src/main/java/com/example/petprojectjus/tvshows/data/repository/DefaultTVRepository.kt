package com.example.petprojectjus.tvshows.data.repository

import com.example.petprojectjus.tvshows.data.mapper.TVModelMapper
import com.example.petprojectjus.tvshows.data.network.TvService
import com.example.petprojectjus.tvshows.domain.model.GetTV
import com.example.petprojectjus.tvshows.domain.repository.TvRepository

class DefaultTVRepository(
    private val tvApi: TvService,
    private val tvModelMapper: TVModelMapper
) : TvRepository {
    override fun getPopularTV(page: Int): List<GetTV> {
        val list = tvApi.getPopularShows().getTVResponses ?: emptyList()
        return list.map { tvModelMapper.toGetTVModel(it) }
    }

    override fun getTopRated(page: Int): List<GetTV> {
        val list = tvApi.getTopRated().getTVResponses ?: emptyList()
        return list.map { tvModelMapper.toGetTVModel(it) }
    }

    override fun getAiringToday(page: Int): List<GetTV> {
        val list = tvApi.getAiringToday().getTVResponses ?: emptyList()
        return list.map { tvModelMapper.toGetTVModel(it) }
    }

    override fun getTrendingTv(page: Int): List<GetTV> {
        val list = tvApi.getTrendingTv().getTVResponses ?: emptyList()
        return list.map { tvModelMapper.toGetTVModel(it) }
    }
}