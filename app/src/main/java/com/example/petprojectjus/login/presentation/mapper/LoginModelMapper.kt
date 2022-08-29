package com.example.petprojectjus.login.presentation.mapper

import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.presentation.LoginDVO

class LoginModelMapper {

    fun toGetLoginModelMapper(from: LoginDVO): LoginModel {
        return LoginModel(
            userName = from.userName,
            password = from.password,
            requestToken = ""
        )
    }
}