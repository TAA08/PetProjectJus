package com.example.petprojectjus.movie.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentMovieBinding
import com.example.petprojectjus.movie.presentation.MovieData
import com.example.petprojectjus.movie.presentation.Error
import com.example.petprojectjus.movie.presentation.Progress
import com.example.petprojectjus.movie.presentation.movie.adapter.other.PopularMovieAdapter
import com.example.petprojectjus.movie.presentation.movie.adapter.other.TrendingMovieAdapter
import com.example.petprojectjus.movie.presentation.movie.adapter.other.UpcomingMovieAdapter
import com.example.petprojectjus.movie.presentation.movie.adapter.playing.PlayingInTheatreAdapter
import com.example.petprojectjus.movie.presentation.movie.adapter.toprated.TopRatedMovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment(R.layout.fragment_movie) {


    private val viewModel by viewModel<MovieViewModel>()

    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding
        get() = _binding ?: throw RuntimeException("MovieFragment is null")

    private val topRatedAdapter = TopRatedMovieAdapter()
    private val playingInTheatreAdapter = PlayingInTheatreAdapter()
    private val trendingMovieAdapter = TrendingMovieAdapter()
    private val upcomingMovieAdapter = UpcomingMovieAdapter()
    private val popularMovieAdapter = PopularMovieAdapter()

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
        /**
         * надо как-то подправить
         */
        getMovies(MoviesType.POPULAR)
        getMovies(MoviesType.PLAYING)
        getMovies(MoviesType.TRENDING)
        getMovies(MoviesType.TOPRATED)
        getMovies(MoviesType.UPCOMING)
        initAndObserveViewModel()
    }

    private fun getMovies(type: MoviesType) {
        viewModel.getMovies(type)
    }

    private fun initAndObserveViewModel() {

        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is Error -> {}
                is Progress -> {}
                is MovieData -> {
                    when (it.type) {
                        MoviesType.POPULAR -> {
                            popularMovieAdapter.submitList(it.movieList)
                            rvPopularMovie.adapter = popularMovieAdapter
                        }
                        MoviesType.PLAYING -> {
                            playingInTheatreAdapter.submitList(it.movieList)
                            rvPlayingNowMovie.adapter = playingInTheatreAdapter
                        }
                        MoviesType.TRENDING -> {
                            trendingMovieAdapter.submitList(it.movieList)
                            rvTrendingMovie.adapter = trendingMovieAdapter
                        }
                        MoviesType.TOPRATED -> {
                            topRatedAdapter.submitList(it.movieList)
                            rvTopRatedMovie.adapter = topRatedAdapter
                        }
                        MoviesType.UPCOMING -> {
                            upcomingMovieAdapter.submitList(it.movieList)
                            rvUpcomingMovie.adapter = upcomingMovieAdapter
                        }
                        else -> {}
                    }
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }
}