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
import org.json.JSONObject

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnRegister.setOnClickListener(){
            val requsetParams = JSONObject()
            requsetParams.put("email", binding.etEmail.text.toString())
            requsetParams.put("password", binding.etPassword.text.toString())
            val url = "https://reqres.in/api/register"
            val queue = Volley.newRequestQueue(this.context)
            val request = JsonObjectRequest(com.android.volley.Request.Method.POST, url, requsetParams,{response ->
                try {
                    d("resultianting", "${response}")
                    Toast.makeText(this.context, "${response}", Toast.LENGTH_LONG).show()
                }catch (e: Exception){
                    d("resultiantingFail", "${e.message}")
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