package com.example.petprojectjus.celebrity.domain.interactor

import com.example.petprojectjus.celebrity.domain.repository.CelebrityRepository

class CelebrityInteractor(
    val celebrityRepository: CelebrityRepository
) {

    suspend fun getPopularCelebrity() = celebrityRepository.getPopularCelebrity()

    suspend fun getTrendingCelebrity() = celebrityRepository.getTrendingCelebrity()

    suspend fun getCelebrityDetails(celebrityId: Int) =
        celebrityRepository.getCelebrityInfo(celebrityId)
}