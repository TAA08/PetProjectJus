package com.example.petprojectjus.celebrity.data.network

data class CelebrityInfoDto(
    var adult: Boolean?,
    var also_known_as: List<String>?,
    var biography: String?,
    var birthday: String?,
    var deathday: Any?,
    var gender: Int?,
    var homepage: Any?,
    var id: Int?,
    var imdb_id: String?,
    var known_for_department: String?,
    var name: String?,
    var place_of_birth: String?,
    var popularity: Double?,
    var profile_path: String?
)