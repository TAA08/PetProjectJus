package com.example.petprojectjus.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petprojectjus.login.domain.interactor.LoginInteractor
import com.example.petprojectjus.login.presentation.mapper.LoginModelMapper
import kotlinx.coroutines.launch


class LoginViewModel(
    private val loginInteractor: LoginInteractor,
    private val loginModelMapper: LoginModelMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<State>()
    val viewState: LiveData<State>
        get() = _viewState

    fun login(loginDVO: LoginDVO) {
        viewModelScope.launch {
            val session = loginInteractor.loginUser(
                loginModel = loginModelMapper.toGetLoginModelMapper(loginDVO)
            )
            if (session.isBlank()) {
                _viewState.value = Error
            } else {
                _viewState.value = SessionData(session)
            }
        }
    }

}