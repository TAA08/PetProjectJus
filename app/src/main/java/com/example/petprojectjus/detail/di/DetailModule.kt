package com.example.petprojectjus.detail.di

import com.example.petprojectjus.RetrofitInstance
import com.example.petprojectjus.detail.data.mapper.CastCrewMapper
import com.example.petprojectjus.detail.data.mapper.MovieDetailMapper
import com.example.petprojectjus.detail.data.mapper.TrailerMapper
import com.example.petprojectjus.detail.data.network.MovieDetailService
import com.example.petprojectjus.detail.data.repository.DefaultMovieDetailRepository
import com.example.petprojectjus.detail.domain.interactor.MovieDetailInteractor
import com.example.petprojectjus.detail.domain.repository.MovieDetailRepository
import com.example.petprojectjus.detail.presentation.MovieDetailViewModel
import com.example.petprojectjus.detail.presentation.mapper.CastCrewDvoMapper
import com.example.petprojectjus.detail.presentation.mapper.MovieDetailDvoMapper
import com.example.petprojectjus.detail.presentation.mapper.TrailerDvoMapper
import com.example.petprojectjus.movie.data.repository.DefaultMovieRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DetailModule = module {

    //data
    single { getMovieDetailApi() }
    factory { CastCrewMapper() }
    factory { MovieDetailMapper() }
    factory { TrailerMapper() }
    single<MovieDetailRepository> {
        DefaultMovieDetailRepository(
            api = get(),
            movieDetailMapper = get(),
            crewMapper = get(),
            trailerMapper = get()
        )
    }
    //domain
    factory { MovieDetailInteractor(movieDetailRepository = get()) }

    //presentation

    factory { CastCrewDvoMapper() }
    factory { MovieDetailDvoMapper() }
    factory { TrailerDvoMapper() }

    viewModel {
        MovieDetailViewModel(
            movieDetailInteractor = get(),
            castCrewDvoMapper = get(),
            movieDetailDvoMapper = get(),
            trailerDvoMapper = get()
        )
    }

}

fun getMovieDetailApi(): MovieDetailService = RetrofitInstance().getServiceApi()