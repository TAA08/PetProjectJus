package com.example.petprojectjus.celebrity.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentTmdbBinding

class TMFragment : Fragment(R.layout.fragment_tmdb) {

    private var _binding: FragmentTmdbBinding? = null
    private val binding: FragmentTmdbBinding
        get() = _binding ?: throw RuntimeException("TMFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTmdbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{

        fun newInstance() : TMFragment{
            return  TMFragment()
        }
    }
}