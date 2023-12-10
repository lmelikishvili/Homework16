package com.example.homework16.register

import android.app.DownloadManager.Request
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.VolleyLog.d
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.homework16.BaseFragment
import com.example.homework16.R
import com.example.homework16.databinding.FragmentRegisterBinding
import com.example.homework16.network.ApiInterface
import com.example.homework16.network.RetrofitInstance
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun setup() {

    }

    override fun setupListeners() {

        binding.btnRegister.setOnClickListener(){
            if (binding.etEmail.text.toString() != "eve.holt@reqres.in"){
                Toast.makeText(context, "Email not Correct!!!", Toast.LENGTH_SHORT)
                    .show()
            }else{
                signup(binding.etEmail.text.toString(), binding.etPassword.text.toString())
            }


        }
    }
    override fun bindData() {

    }

    private fun signup(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = UserBody(email,password)

        retIn.registerUser(registerInfo).enqueue(object :
            Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(context, "${response.body().toString()}", Toast.LENGTH_SHORT)
                        .show()

                    d("registeredUser", "${response.body().toString()}")
                }
                else{
                    Toast.makeText(context, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}