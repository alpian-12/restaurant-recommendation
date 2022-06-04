package com.example.restaurantrecommendation.ui.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.restaurantrecommendation.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    companion object {
        const val CATEGORY_NAME = "Category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.swiperefreshcategory.setOnRefreshListener {
            binding.swiperefreshcategory.isRefreshing = false
        }
        setToolbar()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.apply {
            title = intent.getStringExtra(CATEGORY_NAME)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}