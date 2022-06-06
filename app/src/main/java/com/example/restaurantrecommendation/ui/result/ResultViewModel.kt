package com.example.restaurantrecommendation.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase

class ResultViewModel(restaurantUseCase: RestaurantUseCase): ViewModel() {

    var search: String = ""
    var lat: Double = 0.0
    var long: Double = 0.0

//    val restaurant = restaurantUseCase.searchRestaurant("solaria", -6.175392, 106.827153).asLiveData()

    fun setSearchInfo(search: String, lat: Double, long: Double) {
        this.search = search
        this.lat = lat
        this.long = long
    }

    val restaurant = restaurantUseCase.searchRestaurant(search, lat, long).asLiveData()
}