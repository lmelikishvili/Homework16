package com.example.homework16.login

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.homework16.BaseFragment
import com.example.homework16.R
import com.example.homework16.databinding.FragmentLoginBinding
import com.example.homework16.network.ApiInterface
import com.example.homework16.network.RetrofitInstance
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnLogin.setOnClickListener(){

            if (binding.etEmail.text.toString() != "eve.holt@reqres.in"){
                Toast.makeText(context, "Email not Correct!!!", Toast.LENGTH_SHORT)
                    .show()
            }else{
                signin(binding.etEmail.text.toString(), binding.etPassword.text.toString())
            }
        }
    }
    override fun bindData() {

    }

    private fun signin(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(context, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}

