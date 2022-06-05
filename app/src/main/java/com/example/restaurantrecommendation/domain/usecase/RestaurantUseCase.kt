package com.example.restaurantrecommendation.domain.usecase

import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {
    fun searchRestaurant(search: String, lat: Double, long: Double): Flow<Resource<List<Restaurant>>>
}