package com.example.restaurantrecommendation.ui.detailrestaurant

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        setToolbar()
    }

    private fun setToolbar() {

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle("Detail Restaurant")
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#fefefe")))
            elevation = 0f
        }
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_description,
            R.string.tab_text_review
        )
    }
}