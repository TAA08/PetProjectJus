package com.example.petprojectjus.celebrity.di

import com.example.petprojectjus.RetrofitInstance
import com.example.petprojectjus.celebrity.data.mapper.CelebrityModelMapper
import com.example.petprojectjus.celebrity.data.network.CelebrityService
import com.example.petprojectjus.celebrity.data.repository.DefaultCelebrityRepository
import com.example.petprojectjus.celebrity.domain.interactor.CelebrityInteractor
import com.example.petprojectjus.celebrity.domain.repository.CelebrityRepository
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityDvoMapper
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val CelebrityModule = module {

    //data
    factory { CelebrityModelMapper() }
    single { getCelebrityApi() }
    single<CelebrityRepository> {
        DefaultCelebrityRepository(
            celebrityModelMapper = get(),
            api = get()
        )
    }

    //domain
    factory { CelebrityInteractor(celebrityRepository = get()) }

    //presentation
    factory { CelebrityDvoMapper() }
    viewModel {
        CelebrityViewModel(
            celebrityInteractor = get(),
            mapper = get()
        )
    }


}

private fun getCelebrityApi(): CelebrityService = RetrofitInstance().getServiceApi()