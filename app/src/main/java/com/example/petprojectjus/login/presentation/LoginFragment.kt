package com.example.petprojectjus.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petprojectjus.R
import com.example.petprojectjus.databinding.FragmentLoginBinding
import com.example.petprojectjus.movie.presentation.movie.MovieFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel by viewModel<LoginViewModel>()

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("LoginFragment is null")

    /**
     * словил краш когда забыл get()
     */
    private val etUserName get() = binding.etUsername
    private val etPassword get() = binding.etPassword
    private val bwLogin get() = binding.btnLogin

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onButtonLoginClicked()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onButtonLoginClicked() {
        bwLogin.setOnClickListener {
            if (!etUserName.text.isNullOrBlank() && !etPassword.text.isNullOrBlank()) {
                val data = LoginDvo(
                    userName = etUserName.text.toString().trim(),
                    password = etPassword.text.toString().trim(),
                )
                viewModel.login(data)
                observeViewModel()
            } else {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is Progress -> {}
                is Error -> {
                    Toast.makeText(requireContext(), "Неверные данные", Toast.LENGTH_SHORT).show()
                }
                is SessionData -> {
                    launchMovieFragment()
                }
            }
        }
    }

    private fun launchMovieFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MovieFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }


    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}