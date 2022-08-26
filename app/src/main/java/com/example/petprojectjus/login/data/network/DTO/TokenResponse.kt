package com.example.petprojectjus.login.data.network.DTO

import com.google.gson.annotations.SerializedName

class TokenResponse(
    @SerializedName("request_token")
    var token: String?,
)