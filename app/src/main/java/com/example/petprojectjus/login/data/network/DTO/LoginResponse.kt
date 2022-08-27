package com.example.petprojectjus.login.data.network.DTO

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    /**
     * НЕ ЗАБЫВАЙ ЧТО ИМЕНА ПАРАМЕТРОВ ДОЛЖНЫ СОВПАДТЬ С JSON т.к. ключи не совпадут
     */
    @SerializedName("username")
    val userName: String,
    val password: String,
    @SerializedName("request_token")
    val requestToken: String
)