package com.example.homework16

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.android.volley.VolleyLog
import com.example.homework16.login.SignInBody
import com.example.homework16.network.ApiInterface
import com.example.homework16.network.RetrofitInstance
import com.example.homework16.register.UserBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OperationViewModel:ViewModel()

{
    fun signin(context: Context, email: String, password: String){
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

    fun signup(context: Context, email: String, password: String){
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

                    VolleyLog.d("registeredUser", "${response.body().toString()}")
                }
                else{
                    Toast.makeText(context, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}