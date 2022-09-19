package com.example.petprojectjus.tvshows.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentTvShowBinding
import com.example.petprojectjus.tvshows.presentation.adapter.airing.AiringTVAdapter
import com.example.petprojectjus.tvshows.presentation.adapter.other.PopularTVAdapter
import com.example.petprojectjus.tvshows.presentation.adapter.other.TrendingTVAdapter
import com.example.petprojectjus.tvshows.presentation.adapter.toprated.TopRatedTVAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVFragment : Fragment(R.layout.fragment_tv_show) {

    private val viewModel by viewModel<TVViewModel>()

    private var _binding: FragmentTvShowBinding? = null
    private val binding: FragmentTvShowBinding
        get() = _binding ?: throw RuntimeException("TVFragment is null")

    private val popularAdapter = PopularTVAdapter()
    private val trendingAdapter = TrendingTVAdapter()
    private val airingAdapter = AiringTVAdapter()
    private val topRatedAdapter = TopRatedTVAdapter()

    private val rvAiring get() = binding.rvAiringTodayTv
    private val rvPopular get() = binding.rvPopularTv
    private val rvRated get() = binding.rvTopRatedTv
    private val rvTrend get() = binding.rvTrendingTv

    private val tvAiring get() = binding.airingTodayTv
    private val tvPopular get() = binding.allPopularTv
    private val tvTrending get() = binding.allTrendingTv
    private val tvTop get() = binding.allTopRatedTv


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        for (tvType in TVType.values()) {
            getTVType(tvType)
        }

        tvPopular.setOnClickListener {
            launchEntertainmentTvFragment(TVType.POPULAR)
        }

        tvTop.setOnClickListener {
            launchEntertainmentTvFragment(TVType.TOP_RATED)
        }
        tvTrending.setOnClickListener {
            launchEntertainmentTvFragment(TVType.TRENDING)
        }

        tvAiring.setOnClickListener {
            launchEntertainmentTvFragment(TVType.AIRING_TODAY)
        }

        initViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getTVType(tvType: TVType) {
        viewModel.getTVType(tvType)
    }

    private fun initViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is State.Error -> {}
                is State.Progress -> {}
                is State.TVData -> {
                    when (it.type) {
                        TVType.TRENDING -> {
                            trendingAdapter.submitList(it.tvList)
                            rvTrend.adapter = trendingAdapter
                        }
                        TVType.POPULAR -> {
                            popularAdapter.submitList(it.tvList)
                            rvPopular.adapter = popularAdapter
                        }
                        TVType.TOP_RATED -> {
                            topRatedAdapter.submitList(it.tvList)
                            rvRated.adapter = topRatedAdapter
                        }
                        TVType.AIRING_TODAY -> {
                            airingAdapter.submitList(it.tvList)
                            rvAiring.adapter = airingAdapter
                        }
                        else -> {}
                    }
                }

            }
        }
    }

    private fun launchEntertainmentTvFragment(tvType: TVType) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EntertainmentTvFragment.newInstance(tvType))
            .addToBackStack(EntertainmentTvFragment.NAME)
            .commit()
    }

    companion object {

        fun newInstance(): TVFragment {
            return TVFragment()
        }
    }
}