package com.example.petprojectjus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.petprojectjus.R
import com.example.petprojectjus.celebrity.presentation.CelebrityFragment
import com.example.petprojectjus.celebrity.presentation.SearchFragment
import com.example.petprojectjus.celebrity.presentation.TMFragment
import com.example.petprojectjus.celebrity.presentation.TVFragment
import com.example.petprojectjus.databinding.ActivityMainBinding
import com.example.petprojectjus.login.presentation.LoginFragment
import com.example.petprojectjus.movie.presentation.movie.MovieFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("MainActivity is null")

    private val bnView get()  = binding.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, LoginFragment.newInstance())
            .addToBackStack(null)
            .commit()

        bnView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.movie -> setCurrentFragment(MovieFragment.newInstance())
                R.id.celebrity -> setCurrentFragment(CelebrityFragment.newInstance())
                R.id.tv_show -> setCurrentFragment(TVFragment.newInstance())
                R.id.search -> setCurrentFragment(SearchFragment.newInstance())
                R.id.account -> setCurrentFragment(TMFragment.newInstance())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
}