package com.example.petprojectjus.login.data.mapper

import com.example.petprojectjus.login.data.network.DTO.SessionResponse
import com.example.petprojectjus.login.data.network.DTO.TokenResponse
import com.example.petprojectjus.login.domain.model.SessionModel
import com.example.petprojectjus.login.domain.model.TokenModel

class LoginModelMapper {

    fun toGetTokenModel(from: TokenResponse) = TokenModel(requestToken = from.token ?: "")

    fun toGetSessionModel(from: SessionResponse) = SessionModel(sessionId = from.sessionId ?: "")
}