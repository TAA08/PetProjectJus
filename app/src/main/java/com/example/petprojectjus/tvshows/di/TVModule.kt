package com.example.petprojectjus.tvshows.di

import com.example.petprojectjus.RetrofitInstance
import com.example.petprojectjus.tvshows.data.mapper.TVModelMapper
import com.example.petprojectjus.tvshows.data.repository.DefaultTVRepository
import com.example.petprojectjus.tvshows.domain.interactor.TVInteractor
import com.example.petprojectjus.tvshows.domain.repository.TvRepository
import com.example.petprojectjus.tvshows.presentation.TVViewModel
import com.example.petprojectjus.tvshows.presentation.mapper.TVDvoMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val TVModule = module {
    // data
    factory { TVModelMapper() }
    single { getTVApi() }
    single<TvRepository> {
        DefaultTVRepository(
            tvApi = get(),
            tvModelMapper = get()
        )
    }

    //domain
    factory { TVInteractor(tvRepository = get()) }

    //presentation
    factory { TVDvoMapper() }
    viewModel {
        TVViewModel(
            tvInteractor = get(),
            mapper = get()
        )
    }

}

private fun getTVApi() = RetrofitInstance().getTvApi()