package com.example.petprojectjus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityFragment
import com.example.petprojectjus.celebrity.presentation.SearchFragment
import com.example.petprojectjus.celebrity.presentation.TMFragment
import com.example.petprojectjus.tvshows.presentation.TVFragment
import com.example.petprojectjus.databinding.ActivityMainBinding
import com.example.petprojectjus.login.presentation.LoginFragment
import com.example.petprojectjus.movie.presentation.movie.MovieFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("MainActivity is null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, LoginFragment.newInstance())
            .addToBackStack(LoginFragment.NAME)
            .commit()


    }


}