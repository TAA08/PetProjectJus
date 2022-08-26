package com.example.petprojectjus.login.data.network

import com.example.petprojectjus.login.data.network.DTO.LoginResponse
import com.example.petprojectjus.login.data.network.DTO.SessionResponse
import com.example.petprojectjus.login.data.network.DTO.TokenResponse
import retrofit2.http.*

interface LoginService {

    @GET("authentication/token/new")
    suspend fun createRequestToken(
        @Query("api_key") apiKey: String = API_KEY
    ): TokenResponse

    @POST("authentication/session/new")
    suspend fun createSession(
        @Query("api_key") apiKey: String = API_KEY,
        @Body tokenResponse: TokenResponse
    ) : SessionResponse

    @POST("authentication/token/validate_with_login")
    suspend fun createSessionWithLogin(
        @Query("api_key") apiKey: String = API_KEY,
        @Body loginResponse: LoginResponse
    ) : TokenResponse

    @DELETE("authentication/session")
    suspend fun deleteSession(
        @Query("api_key") apiKey: String = API_KEY,
        @Body sessionResponse : SessionResponse
    )

    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
    }
}