package com.example.petprojectjus.celebrity.data.network

data class CelebrityListDto(
    var page: Int?,
    var celebrityDtos: List<CelebrityDto>?,
    var total_pages: Int?,
    var total_results: Int?
)