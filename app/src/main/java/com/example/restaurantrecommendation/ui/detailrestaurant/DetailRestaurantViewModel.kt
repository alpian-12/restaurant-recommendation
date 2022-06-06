package com.example.restaurantrecommendation.ui.detailrestaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase

class DetailRestaurantViewModel(restaurantUseCase: RestaurantUseCase) : ViewModel() {

    var id: String = ""

//    val restaurant = restaurantUseCase.getDetailRestaurant("ChIJpxhuUTX0aS4RcGEb3hV2ckQ").asLiveData()

    fun setPlaceId(id: String) {
        this.id = id
    }
}