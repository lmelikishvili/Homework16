package com.example.homework16.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework16.BaseFragment
import com.example.homework16.R
import com.example.homework16.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    override fun setup() {

    }

    override fun setupListeners() {
        with(binding){
            btnRegister.setOnClickListener(){
                findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener(){
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
            }
        }
    }

    override fun bindData() {

    }

}