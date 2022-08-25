package com.example.petprojectjus.movie.di

import com.example.petprojectjus.movie.data.mapper.MovieModelMapper
import com.example.petprojectjus.movie.data.network.MovieService
import com.example.petprojectjus.movie.data.network.RetrofitInstance
import com.example.petprojectjus.movie.data.repository.DefaultMovieRepository
import com.example.petprojectjus.movie.domain.interactor.MovieInteractor
import com.example.petprojectjus.movie.domain.repository.MovieRepository
import com.example.petprojectjus.movie.presentation.movie.GetMovieDvoMapper
import com.example.petprojectjus.movie.presentation.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MovieModule = module {
    //data
    factory { MovieModelMapper() }
    single { getMovieApi() }
    single<MovieRepository> {
        DefaultMovieRepository(
            movieApi = get(),
            movieModelMapper = get()
        )
    }

    //domain
    factory { MovieInteractor(movieRepository = get()) }

    //presentation
    factory { GetMovieDvoMapper() }
    viewModel {
        MovieViewModel(
            movieInteractor = get(),
            mapper = get()
        )
    }
}

private fun getMovieApi(): MovieService = RetrofitInstance().getMovieApi()