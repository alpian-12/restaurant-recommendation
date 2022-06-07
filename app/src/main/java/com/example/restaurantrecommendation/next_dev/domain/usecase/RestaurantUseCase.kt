package com.example.restaurantrecommendation.next_dev.domain.usecase

import com.example.restaurantrecommendation.next_dev.data.Resource
import com.example.restaurantrecommendation.model.Restaurant
import com.example.restaurantrecommendation.model.RestaurantDetail
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {
    fun searchRestaurant(search: String, lat: Double, long: Double): Flow<Resource<List<Restaurant>>>
    fun getDetailRestaurant(id: String): Flow<Resource<RestaurantDetail>>
}