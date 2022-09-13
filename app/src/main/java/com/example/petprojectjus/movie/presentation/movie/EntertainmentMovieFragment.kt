package com.example.petprojectjus.movie.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentEntertainmentBinding
import com.example.petprojectjus.movie.presentation.Error
import com.example.petprojectjus.movie.presentation.MovieData
import com.example.petprojectjus.movie.presentation.Progress
import com.example.petprojectjus.movie.presentation.movie.adapter.entertainment.EntertainmentMovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntertainmentMovieFragment : Fragment(R.layout.fragment_entertainment) {

    private var _binding: FragmentEntertainmentBinding? = null
    private val binding: FragmentEntertainmentBinding
        get() = _binding ?: throw RuntimeException("EntertainmentFragment is null")

    private val viewModel by viewModel<MovieViewModel>()

    private val rvMovie get() = binding.rvAll
    private val toolbar get() = binding.toolbar

    private val adapter = EntertainmentMovieAdapter()

    private lateinit var moviesType: MoviesType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntertainmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAndObserveViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun parseArgs() {
        moviesType = requireArguments().getSerializable(MOVIE_TYPE) as MoviesType
        viewModel.getMovies(moviesType)

    }

    private fun initAndObserveViewModel() {

        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is Error -> {}
                is Progress -> {}
                is MovieData -> {
                    adapter.submitList(it.movieList)
                    rvMovie.adapter = adapter
                    when (it.type) {
                        MoviesType.PLAYING -> toolbar.setTitle(PLAYING)
                        MoviesType.POPULAR -> toolbar.setTitle(POPULAR)
                        MoviesType.TOPRATED -> toolbar.setTitle(TOP_RATED)
                        MoviesType.TRENDING -> toolbar.setTitle(TRENDING)
                        MoviesType.UPCOMING -> toolbar.setTitle(UPCOMING)
                    }
                }
            }
        }
    }


    companion object {

        private const val MOVIE_TYPE = "movieType"
        const val NAME = "EntertainmentMovieFragment"
        const val PLAYING = R.string.now_in_theatres
        const val POPULAR = R.string.popular
        const val TOP_RATED = R.string.top_rated
        const val TRENDING = R.string.trending
        const val UPCOMING = R.string.upcoming

        fun newInstance(moviesType: MoviesType): EntertainmentMovieFragment {
            return EntertainmentMovieFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MOVIE_TYPE, moviesType)

                }
            }

        }
    }
}