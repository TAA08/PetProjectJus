package com.example.petprojectjus.login.data.mapper

import com.example.petprojectjus.login.data.network.Dto.LoginRequest
import com.example.petprojectjus.login.data.network.Dto.SessionRequest
import com.example.petprojectjus.login.domain.model.LoginModel
import com.example.petprojectjus.login.domain.model.SessionModel

class LoginResponseMapper {

    fun toGetLoginResponse(from: LoginModel): LoginRequest {
        return LoginRequest(
            userName = from.userName,
            password = from.password,
            requestToken = from.requestToken
        )
    }

    fun toGetSessionResponse(from: SessionModel): SessionRequest {
        return SessionRequest(
            success = true,
            sessionId = from.sessionId
        )
    }
}

/**
 * git knowledges
 *
 * 1. status
 * 2. add, commit, push - staging area, local repository
 * 3. git log & git log --oneline
 * 4. git fetch, pull
 * 5. git merge, not necessary git rebase
 * 6. git stash
 *
 * */