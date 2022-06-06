package com.example.restaurantrecommendation.ui.detailrestaurant

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.adapter.SectionsPagerAdapterRestaurant
import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.databinding.ActivityDetailRestaurantBinding
import com.example.restaurantrecommendation.util.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class DetailRestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRestaurantBinding
    private lateinit var detailRestaurantViewModel: DetailRestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this@DetailRestaurantActivity)
        detailRestaurantViewModel = ViewModelProvider(this, factory)[DetailRestaurantViewModel::class.java]

        setToolbar()
        val placeId: String? = intent.getStringExtra(PLACE_ID)
        setDetailRestaurant()

        val sectionsPagerAdapter = SectionsPagerAdapterRestaurant(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        binding.swiperefresh.setOnRefreshListener {
            binding.swiperefresh.isRefreshing = false
        }
    }

    private fun setDetailRestaurant() {
        detailRestaurantViewModel.restaurant.observe(this@DetailRestaurantActivity) { restaurant ->
            if(restaurant != null) {
                when(restaurant) {
                    is Resource.Success -> {
                        with(binding) {
                            tvName.text = restaurant.data?.name
                            rateRestaurant.text = restaurant.data?.rating.toString()
                        }
                    }
                }
            }
        }


    }

    private fun setToolbar() {
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_description,
            R.string.tab_text_review
        )

        const val PLACE_ID = "place_id"
    }
}