package com.example.petprojectjus.tvshows.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentEntertainmentBinding
import com.example.petprojectjus.tvshows.presentation.adapter.entertainment.EntertainmentTVAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntertainmentTvFragment : Fragment(R.layout.fragment_entertainment) {

    private var _binding: FragmentEntertainmentBinding? = null
    private val binding: FragmentEntertainmentBinding
        get() = _binding ?: throw RuntimeException("EntertainmentFragment is null")

    private val viewModel by viewModel<TVViewModel>()

    private val rvTv get() = binding.rvAll
    private val toolbar get() = binding.toolbar
    private lateinit var tvType: TVType

    private val adapter = EntertainmentTVAdapter()

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

    private fun initAndObserveViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is State.Error -> {}
                is State.Progress -> {}
                is State.TVData -> {
                    adapter.submitList(it.tvList)
                    rvTv.adapter = adapter
                    when (it.type) {
                        TVType.POPULAR -> toolbar.setTitle(POPULAR)
                        TVType.TOP_RATED -> toolbar.setTitle(TOP_RATED)
                        TVType.TRENDING -> toolbar.setTitle(TRENDING)
                        TVType.AIRING_TODAY -> toolbar.setTitle(AIRING_TODAY)
                        else -> {}
                    }
                }
            }
        }
    }


    private fun parseArgs() {
        tvType = requireArguments().getSerializable(TV_TYPE) as TVType
        viewModel.getTVType(tvType)
    }

    companion object {

        private const val TV_TYPE = "tvType"
        const val NAME = "EntertainmentTvFragment"
        const val AIRING_TODAY = R.string.airing_today
        const val POPULAR = R.string.popular
        const val TOP_RATED = R.string.top_rated
        const val TRENDING = R.string.trending

        fun newInstance(tvType: TVType): EntertainmentTvFragment {
            return EntertainmentTvFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(TV_TYPE, tvType)

                }
            }

        }
    }
}