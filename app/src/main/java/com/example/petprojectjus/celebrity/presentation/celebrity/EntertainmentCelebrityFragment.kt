package com.example.petprojectjus.celebrity.presentation.celebrity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.celebrity.presentation.State
import com.example.petprojectjus.celebrity.presentation.celebrity.adapter.entertainment.EntertainmentCelebrityAdapter
import com.example.petprojectjus.databinding.FragmentEntertainmentBinding
import com.example.petprojectjus.movie.presentation.movie.EntertainmentMovieFragment
import com.example.petprojectjus.movie.presentation.movie.MoviesType
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntertainmentCelebrityFragment : Fragment(R.layout.fragment_entertainment) {

    private var _binding: FragmentEntertainmentBinding? = null
    private val binding: FragmentEntertainmentBinding
        get() = _binding ?: throw RuntimeException("EntertainmentFragment is null")

    private val toolbar get() = binding.toolbar
    private val rvCelebrity get() = binding.rvAll

    private val viewModel by viewModel<CelebrityViewModel>()
    private val adapter = EntertainmentCelebrityAdapter()
    private lateinit var celebrityType: CelebrityType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntertainmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAndObserveViewModel()
    }

    private fun parseArgs() {
        celebrityType = requireArguments().getSerializable(CELEBRITY_TYPE) as CelebrityType
        viewModel.getCelebrity(celebrityType)
    }

    private fun initAndObserveViewModel() {

        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is State.Error -> {}
                is State.Loading -> {}
                is State.CelebrityData -> {
                    adapter.submitList(it.celebrityList)
                    rvCelebrity.adapter = adapter
                    when (it.celebrityType) {
                        CelebrityType.TRENDING -> toolbar.setTitle(TRENDING)
                        CelebrityType.POPULAR -> toolbar.setTitle(POPULAR)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val TRENDING = R.string.trending
        const val POPULAR = R.string.popular
        const val CELEBRITY_TYPE = "celebrity type"

        fun newInstance(celebrityType: CelebrityType): EntertainmentCelebrityFragment {
            return EntertainmentCelebrityFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(CELEBRITY_TYPE, celebrityType)

                }
            }

        }
    }

}