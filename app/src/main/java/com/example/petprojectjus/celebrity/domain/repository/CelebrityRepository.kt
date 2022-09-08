package com.example.petprojectjus.celebrity.domain.repository

import com.example.petprojectjus.celebrity.domain.model.Celebrity
import com.example.petprojectjus.celebrity.domain.model.CelebrityInfo

interface CelebrityRepository {

    suspend fun getPopularCelebrity() : List<Celebrity>

    suspend fun getTrendingCelebrity() : List<Celebrity>

    suspend fun getCelebrityInfo(celebrityId : Int) : CelebrityInfo
}