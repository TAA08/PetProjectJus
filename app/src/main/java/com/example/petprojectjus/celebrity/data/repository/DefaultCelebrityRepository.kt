package com.example.petprojectjus.celebrity.data.repository

import com.example.petprojectjus.celebrity.data.mapper.CelebrityModelMapper
import com.example.petprojectjus.celebrity.data.network.CelebrityService
import com.example.petprojectjus.celebrity.domain.model.Celebrity
import com.example.petprojectjus.celebrity.domain.model.CelebrityInfo
import com.example.petprojectjus.celebrity.domain.repository.CelebrityRepository

class DefaultCelebrityRepository(
    val celebrityModelMapper: CelebrityModelMapper,
    val api: CelebrityService
) : CelebrityRepository {

    override suspend fun getPopularCelebrity(): List<Celebrity> {
        return try {
            val list = api.getPopularCelebrity().celebrityDto
            list?.map { celebrityModelMapper.toGetCelebrityModel(it) } ?: emptyList()
        }catch (e : Exception){
            emptyList()
        }

    }

    override suspend fun getTrendingCelebrity(): List<Celebrity> {
        return try {
            val list = api.getTrendingCelebrity().celebrityDto
            return list?.map { celebrityModelMapper.toGetCelebrityModel(it) } ?: emptyList()
        }
        catch (e : Exception){
            emptyList()
        }
    }

    override suspend fun getCelebrityInfo(celebrityId: Int): CelebrityInfo {
        return celebrityModelMapper.toGetCelebrityInfo(api.getCelebrityDetails(celebrityId))
    }
}