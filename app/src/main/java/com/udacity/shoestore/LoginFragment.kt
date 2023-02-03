package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.apply {
            loginButton.setOnClickListener { navigateToNextScreen() }
            signupButton.setOnClickListener { navigateToNextScreen() }
        }

        return binding.root
    }

    private fun navigateToNextScreen() {
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }
}