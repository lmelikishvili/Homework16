package com.example.homework16.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.homework16.BaseFragment
import com.example.homework16.OperationViewModel
import com.example.homework16.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: OperationViewModel by viewModels()
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnLogin.setOnClickListener(){

            if (binding.etEmail.text.toString() != "eve.holt@reqres.in"){
                Toast.makeText(context, "Email not Correct!!!", Toast.LENGTH_SHORT)
                    .show()
            }else{
                context?.let { it1 -> viewModel.signin(it1, binding.etEmail.text.toString(), binding.etPassword.text.toString()) }
            }
        }
    }
    override fun bindData() {

    }
}

