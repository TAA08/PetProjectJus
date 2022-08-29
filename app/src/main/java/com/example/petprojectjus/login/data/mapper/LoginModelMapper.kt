package com.example.petprojectjus.login.data.mapper

import com.example.petprojectjus.login.data.network.DTO.SessionResponse
import com.example.petprojectjus.login.data.network.DTO.TokenResponse
import com.example.petprojectjus.login.domain.model.SessionModel
import com.example.petprojectjus.login.domain.model.TokenModel

class LoginModelMapper {



    fun toGetSessionModel(from: SessionResponse) = SessionModel(sessionId = from.sessionId ?: "")
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