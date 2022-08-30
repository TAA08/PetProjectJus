package com.example.petprojectjus.login.data.network.Dto

import com.google.gson.annotations.SerializedName

data class SessionRequest (
    @SerializedName("success")
    var success: Boolean?,
    @SerializedName("session_id")
    var sessionId: String?
)