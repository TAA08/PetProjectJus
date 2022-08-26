package com.example.petprojectjus.login.data.network.DTO

import com.google.gson.annotations.SerializedName

data class SessionResponse (
    @SerializedName("session_id")
    var success: Boolean?,
    @SerializedName("session_id")
    var sessionId: String?
)