package com.example.petprojectjus.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentMovieDetailBinding
import com.example.petprojectjus.detail.presentation.adapter.cast.MovieCastAdapter
import com.example.petprojectjus.detail.presentation.adapter.detail.MovieInfoAdapter
import com.example.petprojectjus.detail.presentation.adapter.detail.SimilarMovieAdapter
import com.example.petprojectjus.detail.presentation.dvo.MovieDetailDvo
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding: FragmentMovieDetailBinding
        get() = _binding ?: throw RuntimeException("MovieDetailFragment is null")

    private val viewModel by viewModel<MovieDetailViewModel>()

    private var movieId: Int = 0


    //    private val rvCollection get() = binding.rvCollection
    private val rvCastCrew get() = binding.rvCastCrew
    private val rvVideo get() = binding.rvVideo
    private val rvRecommendation get() = binding.rvRecommendation
    private val rvSimilar get() = binding.rvSimilar

    private val adapterSimilar = SimilarMovieAdapter()
    private val adapterRecommendation = SimilarMovieAdapter()

    //    private val adapterVideo =
    private val adapterCast = MovieCastAdapter()

    // возьму для жанров
    private val adapterInformation = MovieInfoAdapter()

    private val tvAllSimilar get() = binding.allSimilar
    private val tvAllRecommendation get() = binding.allRecommendation
    private val tvCast get() = binding.allCastCrew

    private val tvDateRelease get() = binding.dateRelease
    private val tvLanguage get() = binding.language
    private val tvBudget get() = binding.budget
    private val tvRevenue get() = binding.revenue
    private val tvProduction get() = binding.production
    private val tvDescription get() = binding.movieDescription
    private val tvTitle get() = binding.movieTitle
    private val imPoster get() = binding.moviePoster
    private val imImage get() = binding.movieImage
    private val tvVote get() = binding.vote
    private val tvRating get() = binding.rating
    private val rbRating get() = binding.ratingBar
    private val rvGenre get() = binding.rvGenre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvAllSimilar.setOnClickListener {

        }

        tvAllRecommendation.setOnClickListener {

        }

        tvCast.setOnClickListener {

        }
        initAndObserveViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initAndObserveViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Loading -> {}
                is State.Error -> {}
                is State.Result -> {
                    viewModel.cast.observe(viewLifecycleOwner) { cast ->
                        adapterCast.submitList(cast)
                        rvCastCrew.adapter = adapterCast
                    }
                    viewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
                        bindValue(movieDetail)
                    }
                    viewModel.trailer.observe(viewLifecycleOwner) { trailer ->
//                        adapterVideo.submitList(trailer)
                        rvSimilar.adapter = adapterSimilar
                    }
                }
                is State.MovieType -> {
                    when (state.movieDetailType) {
                        MovieDetailType.SIMILAR -> {
                            adapterSimilar.submitList(state.movieList)
                            rvSimilar.adapter = adapterSimilar

                        }
                        MovieDetailType.RECOMMENDATION -> {
                            adapterRecommendation.submitList(state.movieList)
                            rvRecommendation.adapter = adapterRecommendation
                        }
                    }
                }
            }
        }
    }

    private fun parseArgs() {
        movieId = requireArguments().getInt(MOVIE_ID)
        viewModel.getMovieById(movieId)
        for (movieType in MovieDetailType.values()) {
            viewModel.getMovieType(movieId = movieId, movieDetailType = movieType)
        }

    }

    private fun bindValue(movieDetail: MovieDetailDvo) {
        tvDateRelease.text = movieDetail.releaseDate
        tvRevenue.text = movieDetail.revenue.toString()
        tvBudget.text = movieDetail.budget.toString()
        tvDescription.text = movieDetail.overview
        tvLanguage.text = movieDetail.originalLanguage
        tvRating.text = movieDetail.voteAverage.toString()
        tvVote.text = movieDetail.voteCount.toString()
        tvTitle.text = movieDetail.title
        tvProduction.text = movieDetail.productionCompanies.toString()
        Picasso.get().load(IMAGE_URL + movieDetail.backdropPath).into(imPoster)
        Picasso.get().load(IMAGE_URL + movieDetail.posterPath).into(imImage)
        rbRating.rating = (movieDetail.voteAverage / 2).toFloat()

    }

    companion object {

        private const val MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): MovieDetailFragment {
            return MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_ID, movieId)
                }
            }
        }
    }
}