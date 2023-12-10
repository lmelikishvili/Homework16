package com.example.homework16.register

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.homework16.BaseFragment
import com.example.homework16.OperationViewModel
import com.example.homework16.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: OperationViewModel by viewModels()
    override fun setup() {

    }

    override fun setupListeners() {

        binding.btnRegister.setOnClickListener(){
            if (binding.etEmail.text.toString() != "eve.holt@reqres.in"){
                Toast.makeText(context, "Email not Correct!!!", Toast.LENGTH_SHORT)
                    .show()
            }else{
                this.context?.let { it1 -> viewModel.signup(it1, binding.etEmail.text.toString(), binding.etPassword.text.toString()) }
            }
        }
    }
    override fun bindData() {

    }
}