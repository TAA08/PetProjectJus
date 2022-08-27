package com.example.petprojectjus.login.data.repository

import com.example.petprojectjus.login.data.mapper.LoginModelMapper
import com.example.petprojectjus.login.data.network.DTO.LoginResponse
import com.example.petprojectjus.login.data.network.LoginService
import com.example.petprojectjus.login.domain.mapper.LoginResponseMapper
import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel
import com.example.petprojectjus.login.domain.repository.LoginRepository

class DefaultLoginRepository(
    private val loginApi: LoginService,
    private val loginModelMapper: LoginModelMapper,
    private val loginResponseMapper: LoginResponseMapper
) : LoginRepository {

    override suspend fun loginUser(loginModel: LoginModel): String {
        val requestToken = loginApi.createRequestToken().token
        val userName = loginResponseMapper.toGetLoginResponse(loginModel).userName
        val password = loginResponseMapper.toGetLoginResponse(loginModel).password
        val loginResponse =
            LoginResponse(
                userName = userName,
                password = password,
                requestToken = requestToken ?: ""
            )
        val token = loginApi.createSessionWithLogin(loginResponse = loginResponse)
        val session = loginApi.createSession(tokenResponse = token )
        return session.sessionId ?: ""
    }

    override suspend fun logoutUser(sessionModel: SessionModel) {
        loginApi.deleteSession(
            sessionResponse = loginResponseMapper.toGetSessionResponse(
                sessionModel
            )
        )
    }
}