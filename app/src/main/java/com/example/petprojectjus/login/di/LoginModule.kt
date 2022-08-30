package com.example.petprojectjus.login.di

import com.example.petprojectjus.RetrofitInstance
import com.example.petprojectjus.login.data.mapper.LoginResponseMapper
import com.example.petprojectjus.login.data.network.LoginService
import com.example.petprojectjus.login.data.repository.DefaultLoginRepository
import com.example.petprojectjus.login.domain.interactor.LoginInteractor
import com.example.petprojectjus.login.domain.repository.LoginRepository
import com.example.petprojectjus.login.presentation.LoginViewModel
import com.example.petprojectjus.login.presentation.mapper.LoginModelMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginModule = module {

    //data
    factory { LoginResponseMapper() }
    single { getLoginApi() }
    single<LoginRepository> {
        DefaultLoginRepository(
            loginApi = get(),
            loginResponseMapper = get()
        )
    }

    //domain
    factory { LoginInteractor(loginRepository = get()) }


    //presentation
    factory { LoginModelMapper() }
    viewModel {
        LoginViewModel(
            loginInteractor = get(),
            loginModelMapper = get()
        )
    }

}

private fun getLoginApi(): LoginService = RetrofitInstance().getLoginApi()