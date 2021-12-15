package com.practicle.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.practicle.R
import com.practicle.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onLogin(view: View) {
        if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString()
                .isNotEmpty()
        ) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Toast.makeText(this, "Please enter your Email or Password!!", Toast.LENGTH_LONG).show()
        }
    }
}