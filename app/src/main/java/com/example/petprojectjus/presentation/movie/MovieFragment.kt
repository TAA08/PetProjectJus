package com.example.petprojectjus.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentMovieBinding
import com.example.petprojectjus.presentation.Data
import com.example.petprojectjus.presentation.Error
import com.example.petprojectjus.presentation.Progress
import com.example.petprojectjus.presentation.State
import com.example.petprojectjus.presentation.movie.adapter.PlayingInTheatreAdapter
import com.example.petprojectjus.presentation.movie.adapter.PopularMovieAdapter
import com.example.petprojectjus.presentation.movie.adapter.TopRatedMovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment(R.layout.fragment_movie) {


    private val viewModel by viewModel<MovieViewModel>()

    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding
        get() = _binding ?: throw RuntimeException("MovieFragment is null")

    private val topRatedAdapter = TopRatedMovieAdapter()
    private val playingInTheatreAdapter = PlayingInTheatreAdapter()

    /**
     *  Использование одного адаптера для popular, trends, upcoming
     */
    private val otherTypeMovieAdapter = PopularMovieAdapter()

    private val tvPopularMovie get() = binding.allPopularMovie
    private val tvPlayingNowMovie get() = binding.allPlayingNowMovie
    private val tvTrendingMovie get() = binding.allTrendingMovie
    private val tvTopRatedMovie get() = binding.allTopRatedMovie
    private val tvUpcomingMovie get() = binding.allUpcomingMovie

    private val rvPopularMovie get() = binding.rvPopularMovies
    private val rvPlayingNowMovie get() = binding.rvPlayingNowMovies
    private val rvTrendingMovie get() = binding.rvTrendingMovies
    private val rvTopRatedMovie get() = binding.rvTopRatedMovies
    private val rvUpcomingMovie get() = binding.rvUpcomingMovies

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initAndObserveViewModel(){

        viewModel.viewState.observe(viewLifecycleOwner){
            when(it){
                is Error -> {}
                is Progress -> {}
                is Data -> viewModel.{
                    topRatedAdapter.submitList()
                    rvPopularMovie.adapter

                }
            }
        }
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}