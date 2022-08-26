package com.example.petprojectjus.login.domain.interactor

import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel
import com.example.petprojectjus.login.domain.repository.LoginRepository

class LoginInteractor(
    private val loginRepository: LoginRepository
) {
    suspend fun loginUser(loginModel: LoginModel) = loginRepository.loginUser(loginModel)

    suspend fun logoutUser(sessionModel: SessionModel) = loginRepository.logoutUser(sessionModel)
}