package com.example.petprojectjus.celebrity.presentation.celebrity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.celebrity.presentation.State
import com.example.petprojectjus.celebrity.presentation.celebrity.adapter.popular.PopularAdapter
import com.example.petprojectjus.celebrity.presentation.celebrity.adapter.trending.TrendingAdapter
import com.example.petprojectjus.databinding.FragmentCelebritiesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CelebrityFragment : Fragment(R.layout.fragment_celebrities) {

    private var _binding: FragmentCelebritiesBinding? = null
    private val binding: FragmentCelebritiesBinding
        get() = _binding ?: throw RuntimeException("CelebrityFragment is null")

    private val viewModel by viewModel<CelebrityViewModel>()

    private val popularAdapter1 = PopularAdapter()
    private val popularAdapter2 = PopularAdapter()
    private val trendingAdapter = TrendingAdapter()

    private val tvPopularCelebrity get() = binding.allPopularCelebrity
    private val tvTrendingCelebrity get() = binding.allTrendingCelebrity

    private val rvPopularCelebrity1 get() = binding.rvPopularCelebrity1
    private val rvPopularCelebrity2 get() = binding.rvPopularCelebrity2
    private val rvTrendingCelebrity get() = binding.rvTrendingCelebrity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCelebritiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (celebrityType in CelebrityType.values()) {
            getCelebrity(celebrityType)
        }
        initAndObserveViewModel()

        tvPopularCelebrity.setOnClickListener {
            launchEntertainmentCelebrityFragment(CelebrityType.POPULAR)
        }

        tvTrendingCelebrity.setOnClickListener {
            launchEntertainmentCelebrityFragment(CelebrityType.TRENDING)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getCelebrity(celebrityType: CelebrityType) {
        viewModel.getCelebrity(celebrityType)
    }

    private fun initAndObserveViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is State.Error -> {}
                is State.Loading -> {}
                is State.CelebrityData ->
                    when (it.celebrityType) {
                        CelebrityType.POPULAR -> {
                            popularAdapter1.submitList(it.celebrityList.take(10))
                            popularAdapter2.submitList(it.celebrityList.takeLast(10))
                            rvPopularCelebrity1.adapter = popularAdapter1
                            rvPopularCelebrity2.adapter = popularAdapter2
                        }
                        CelebrityType.TRENDING -> {
                            trendingAdapter.submitList(it.celebrityList)
                            rvTrendingCelebrity.adapter = trendingAdapter

                        }
                    }
            }
        }
    }

    private fun launchEntertainmentCelebrityFragment(celebrityType: CelebrityType) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                EntertainmentCelebrityFragment.newInstance(celebrityType)
            )
            .addToBackStack(null)
            .commit()
    }


    companion object {

        fun newInstance(): CelebrityFragment {
            return CelebrityFragment()
        }
    }
}