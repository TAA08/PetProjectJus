package com.example.petprojectjus.login.data.network.DTO

data class LoginResponse(
    val userName: String,
    val password: String,
    val requestToken: String
)