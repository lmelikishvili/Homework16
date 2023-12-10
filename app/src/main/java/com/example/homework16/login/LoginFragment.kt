package com.example.homework16.login

import android.os.Bundle
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
import org.json.JSONObject


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnLogin.setOnClickListener(){
            val requsetParams = JSONObject()
            requsetParams.put("email", binding.etEmail.text.toString())
            requsetParams.put("password", binding.etPassword.text.toString())
            val url = "https://reqres.in/api/login"
            val queue = Volley.newRequestQueue(this.context)
            val request = JsonObjectRequest(Request.Method.POST, url, requsetParams,{ response ->
                try {
                    VolleyLog.d("resultianting", "${response}")
                    Toast.makeText(this.context, "${response}", Toast.LENGTH_LONG).show()
                }catch (e: Exception){
                    VolleyLog.d("resultiantingFail", "${e.message}")
                }
            }, {error ->
                Toast.makeText(this.context, "Message Error", Toast.LENGTH_LONG).show()
            })
            queue.add(request)
        }
    }
    override fun bindData() {

    }

}