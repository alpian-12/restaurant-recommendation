package com.example.restaurantrecommendation.ui.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantrecommendation.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}