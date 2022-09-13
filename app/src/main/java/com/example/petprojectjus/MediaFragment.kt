package com.example.petprojectjus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petprojectjus.celebrity.presentation.SearchFragment
import com.example.petprojectjus.celebrity.presentation.TMFragment
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityFragment
import com.example.petprojectjus.databinding.FragmentMediaBinding
import com.example.petprojectjus.login.presentation.LoginFragment
import com.example.petprojectjus.movie.presentation.movie.MovieFragment
import com.example.petprojectjus.tvshows.presentation.TVFragment

class MediaFragment : Fragment(R.layout.fragment_media) {

    private var _binding: FragmentMediaBinding? = null
    private val binding: FragmentMediaBinding
        get() = _binding ?: throw RuntimeException("MediaFragment is null")

    private val bnView get() = binding.bottomNavigation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieFragment.newInstance())
            .addToBackStack(null)
            .commit()

        bnView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movie -> setCurrentFragment(MovieFragment.newInstance())
                R.id.celebrity -> setCurrentFragment(CelebrityFragment.newInstance())
                R.id.tv_show -> setCurrentFragment(TVFragment.newInstance())
                R.id.search -> setCurrentFragment(SearchFragment.newInstance())
                R.id.account -> setCurrentFragment(TMFragment.newInstance())
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }


    companion object {

        fun newInstance(): MediaFragment {
            return MediaFragment()
        }
    }
}