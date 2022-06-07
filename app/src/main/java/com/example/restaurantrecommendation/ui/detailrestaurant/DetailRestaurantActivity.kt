package com.example.restaurantrecommendation.ui.detailrestaurant

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.adapter.SectionsPagerAdapterRestaurant
import com.example.restaurantrecommendation.databinding.ActivityDetailRestaurantBinding
import com.example.restaurantrecommendation.next_dev.util.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class DetailRestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRestaurantBinding
    private lateinit var detailRestaurantViewModel: DetailRestaurantViewModel
    private lateinit var placeId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        placeId = intent.getStringExtra(PLACE_ID)!!
        detailRestaurantViewModel.setDetailRestaurant(placeId)

        setToolbar()

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
        showProgress(true)
        detailRestaurantViewModel.restaurant.observe(this) {
            binding.apply {
                tvName.text = it.name
                rateRestaurant.text = it.rating.toString()

                constraintLayout.isVisible = true
                showProgress(false)
            }
        }
    }

    private fun showProgress(state: Boolean) {
        binding.progress.isVisible = state
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