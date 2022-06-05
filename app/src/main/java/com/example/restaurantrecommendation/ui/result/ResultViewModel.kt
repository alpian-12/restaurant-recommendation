package com.example.restaurantrecommendation.ui.result

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase

class ResultViewModel(restaurantUseCase: RestaurantUseCase): ViewModel() {
    var search: String = ""
    var location: Location? = null

    val restaurant = restaurantUseCase.searchRestaurant("solaria", -6.175392, 106.827153).asLiveData()
}