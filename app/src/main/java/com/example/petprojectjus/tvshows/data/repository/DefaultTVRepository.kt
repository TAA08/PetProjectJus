package com.example.petprojectjus.tvshows.data.repository

import com.example.petprojectjus.tvshows.data.mapper.TVModelMapper
import com.example.petprojectjus.tvshows.data.network.TvService
import com.example.petprojectjus.tvshows.domain.model.GetTV
import com.example.petprojectjus.tvshows.domain.repository.TvRepository

class DefaultTVRepository(
    private val tvApi: TvService,
    private val tvModelMapper: TVModelMapper
) : TvRepository {

    override suspend fun getPopularTV(page: Int): List<GetTV> {
        return try {
            val list = tvApi.getPopularShows().getTVResponses ?: emptyList()
            list.map { tvModelMapper.toGetTVModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getTopRated(page: Int): List<GetTV> {
        return try {
            val list = tvApi.getTopRated().getTVResponses ?: emptyList()
            return list.map { tvModelMapper.toGetTVModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAiringToday(page: Int): List<GetTV> {
        return try {
            val list = tvApi.getAiringToday().getTVResponses ?: emptyList()
            return list.map { tvModelMapper.toGetTVModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getTrendingTv(page: Int): List<GetTV> {
        return try {
            val list = tvApi.getTrendingTv().getTVResponses ?: emptyList()
            return list.map { tvModelMapper.toGetTVModel(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }
}