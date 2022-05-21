package com.example.restaurantrecommendation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.restaurantrecommendation.ui.detailrestaurant.descriptiondetailrestaurant.DescriptionRestaurantFragment
import com.example.restaurantrecommendation.ui.detailrestaurant.reviewdetailrestaurant.ReviewDetailRestaurantFragment

class SectionsPagerAdapterRestaurant(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DescriptionRestaurantFragment()
            1 -> fragment = ReviewDetailRestaurantFragment()
        }
        return fragment as Fragment
    }

}