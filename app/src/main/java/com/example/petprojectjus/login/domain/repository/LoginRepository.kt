package com.example.petprojectjus.login.domain.repository

import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel

interface LoginRepository {

    suspend fun loginUser(loginModel: LoginModel): String

    suspend fun logoutUser(sessionModel: SessionModel)
}