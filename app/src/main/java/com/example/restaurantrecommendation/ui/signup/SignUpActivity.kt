package com.example.restaurantrecommendation.ui.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.databinding.ActivitySignUpBinding
import com.example.restaurantrecommendation.ui.login.LoginActivity
import com.example.restaurantrecommendation.ui.main.MainActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var ActionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //hide action bar
        supportActionBar!!.hide()


    }
}

