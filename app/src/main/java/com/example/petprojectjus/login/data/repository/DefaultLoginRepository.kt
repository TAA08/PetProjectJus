package com.example.petprojectjus.login.data.repository

import com.example.petprojectjus.login.data.mapper.LoginResponseMapper
import com.example.petprojectjus.login.data.network.Dto.LoginRequest
import com.example.petprojectjus.login.data.network.LoginService
import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel
import com.example.petprojectjus.login.domain.repository.LoginRepository

class DefaultLoginRepository(
    private val loginApi: LoginService,
    private val loginResponseMapper: LoginResponseMapper
) : LoginRepository {

    override suspend fun loginUser(loginModel: LoginModel): String {
        return try {
            val requestToken = loginApi.createRequestToken().token
            val userName = loginResponseMapper.toGetLoginResponse(loginModel).userName
            val password = loginResponseMapper.toGetLoginResponse(loginModel).password
            val loginRequest = LoginRequest(
                userName = userName,
                password = password,
                requestToken = requestToken ?: ""
            )
            val token = loginApi.createSessionWithLogin(loginRequest = loginRequest)
            val session = loginApi.createSession(tokenResponse = token)
            session.sessionId ?: ""
        } catch (e: Exception) {
            return ""
        }

    }

    override suspend fun logoutUser(sessionModel: SessionModel) {
        loginApi.deleteSession(
            sessionRequest = loginResponseMapper.toGetSessionResponse(
                sessionModel
            )
        )
    }
}