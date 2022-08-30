package com.example.petprojectjus.login.data.network.Dto

import com.google.gson.annotations.SerializedName

class TokenResponse(
    @SerializedName("request_token")
    var token: String?,
)