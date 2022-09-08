package com.example.petprojectjus.celebrity.data.network

data class CelebrityDto(
    var adult: Boolean?,
    var gender: Int?,
    var id: Int?,
    var known_for: List<KnownForDto>?,
    var known_for_department: String?,
    var name: String?,
    var popularity: Double?,
    var profile_path: String?
)