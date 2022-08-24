package com.example.petprojectjus.di

import com.example.petprojectjus.data.network.MovieService
import com.example.petprojectjus.data.network.RetrofitInstance
import com.example.petprojectjus.data.repository.DefaultMovieRepository
import com.example.petprojectjus.domain.interactor.MovieInteractor
import com.example.petprojectjus.domain.repository.MovieRepository
import com.example.petprojectjus.presentation.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { getMovieApi() }
}

private fun getMovieApi(): MovieService = RetrofitInstance.getMovieApi()

val repositoryModule = module {
    single<MovieRepository> {
        DefaultMovieRepository(
            movieService = get(),
            movieModelMapper = get()
        )
    }
}

val interactorModule = module {
    single { MovieInteractor(movieRepository = get()) }
}

val viewModelModule = module {
    viewModel {
        MovieViewModel(
            movieInteractor = get(),
            mapper = get()
        )
    }
}

val appModule = networkModule + repositoryModule + interactorModule + viewModelModule