package com.example.restaurantrecommendation.ui.auth.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantrecommendation.data.source.remote.network.Firebase
import com.example.restaurantrecommendation.databinding.ActivitySignUpBinding
import com.example.restaurantrecommendation.ui.auth.login.LoginActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.google.firebase.auth.ktx.userProfileChangeRequest

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }

        binding.btnSignup.setOnClickListener {
            signup()
        }
    }

    private fun signup() {
        with(binding) {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            Firebase.authInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this@SignUpActivity) { task ->
                    if (task.isSuccessful) {
                        Firebase.currentUser().updateProfile(
                            userProfileChangeRequest {
                                displayName = name
                            }
                        )

                        startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
                        finish()
                    }
                }
        }
    }
}

