package com.example.restaurantrecommendation.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantrecommendation.remote.network.Firebase
import com.example.restaurantrecommendation.databinding.ActivityLoginBinding
import com.example.restaurantrecommendation.ui.auth.signup.SignUpActivity
import com.example.restaurantrecommendation.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            signup.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

            btnLogin.setOnClickListener{
                login()
            }

        }
    }

    private fun login() {
        with(binding) {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            Firebase.authInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}