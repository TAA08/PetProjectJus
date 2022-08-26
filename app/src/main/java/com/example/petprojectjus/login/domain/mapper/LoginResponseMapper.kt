package com.example.petprojectjus.login.domain.mapper

import com.example.petprojectjus.login.data.network.DTO.LoginResponse
import com.example.petprojectjus.login.data.network.DTO.SessionResponse
import com.example.petprojectjus.login.data.network.DTO.TokenResponse
import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel

class LoginResponseMapper {

    fun toGetLoginResponse(from: LoginModel): LoginResponse {
        return LoginResponse(
            userName = from.userName,
            password = from.password,
            requestToken = from.requestToken
        )
    }

    fun toGetSessionResponse(from: SessionModel): SessionResponse {
        return SessionResponse(
            success = true,
            sessionId = from.sessionId
        )
    }
}