package com.example.petprojectjus.celebrity.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentCelebritiesBinding

class CelebrityFragment : Fragment(R.layout.fragment_celebrities) {

    private var _binding: FragmentCelebritiesBinding? = null
    private val binding: FragmentCelebritiesBinding
        get() = _binding ?: throw RuntimeException("CelebrityFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCelebritiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance(): CelebrityFragment {
            return CelebrityFragment()
        }
    }
}