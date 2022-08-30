package com.example.petprojectjus.login.data.network

import com.example.petprojectjus.login.data.network.Dto.LoginRequest
import com.example.petprojectjus.login.data.network.Dto.SessionRequest
import com.example.petprojectjus.login.data.network.Dto.TokenResponse
import retrofit2.http.*

interface LoginService {
    /**
     * Получаем токен для прохождения процесса авторизации
     */
    @GET("authentication/token/new")
    suspend fun createRequestToken(
        @Query("api_key") apiKey: String = API_KEY
    ): TokenResponse

    /**
     * После авторизации получаем токен и получаем сессию входа в свой аккаунт
     */
    @POST("authentication/session/new")
    suspend fun createSession(
        @Query("api_key") apiKey: String = API_KEY,
        @Body tokenResponse: TokenResponse
    ) : SessionRequest

    /**
     * Отправляем полученный токен в GET запросе и вводим данные username, password
     */
    @POST("authentication/token/validate_with_login")
    suspend fun createSessionWithLogin(
        @Query("api_key") apiKey: String = API_KEY,
        @Body loginRequest: LoginRequest
    ) : TokenResponse

    @DELETE("authentication/session")
    suspend fun deleteSession(
        @Query("api_key") apiKey: String = API_KEY,
        @Body sessionRequest : SessionRequest
    )

    companion object {

        private const val API_KEY = "2672c5e5006041431f2be6a17b6f7ceb"
    }
}