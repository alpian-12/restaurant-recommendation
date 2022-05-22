package com.example.restaurantrecommendation.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantrecommendation.databinding.ActivityLoginBinding
import com.example.restaurantrecommendation.ui.detailrestaurant.DetailRestaurantActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.example.restaurantrecommendation.ui.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hide action bar
        supportActionBar!!.hide()
        with(binding) {
            signup.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

            btnLogin.setOnClickListener {
                startActivity(Intent(this@LoginActivity, DetailRestaurantActivity::class.java))
            }
        }
    }
}