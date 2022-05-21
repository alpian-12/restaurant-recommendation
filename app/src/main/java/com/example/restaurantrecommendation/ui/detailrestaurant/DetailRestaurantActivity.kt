package com.example.restaurantrecommendation.ui.detailrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.adapter.SectionsPagerAdapterRestaurant
import com.example.restaurantrecommendation.databinding.ActivityDetailRestaurantBinding
import com.example.restaurantrecommendation.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailRestaurantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapterRestaurant(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs,binding.viewPager){tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_description,
            R.string.tab_text_review
        )
    }
}