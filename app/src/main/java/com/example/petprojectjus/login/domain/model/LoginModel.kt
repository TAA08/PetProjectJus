package com.example.petprojectjus.login.domain.model

data class LoginModel(
    val userName: String,
    val password: String,
    val requestToken: String
)