package com.example.restaurantrecommendation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.restaurantrecommendation.databinding.ActivitySplashBinding
import com.example.restaurantrecommendation.ui.auth.signup.SignUpActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = FirebaseAuth.getInstance().currentUser
        Handler(mainLooper).postDelayed({
            if (user != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, SignUpActivity::class.java))
                finish()
            }
        }, 2000)
    }
}