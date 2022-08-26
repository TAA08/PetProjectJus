package com.example.petprojectjus.login.presentation

sealed class State

object Error : State()

object Progress : State()

data class SessionData(val session : String) : State()
