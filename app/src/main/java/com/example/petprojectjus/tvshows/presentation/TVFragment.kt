package com.example.petprojectjus.celebrity.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentCelebritiesBinding
import com.example.petprojectjus.databinding.FragmentTvShowBinding

class TVFragment : Fragment(R.layout.fragment_tv_show) {

    private var _binding: FragmentTvShowBinding? = null
    private val binding: FragmentTvShowBinding
        get() = _binding ?: throw RuntimeException("TVFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance(): TVFragment {
            return TVFragment()
        }
    }
}