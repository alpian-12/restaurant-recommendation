package com.example.restaurantrecommendation.data.domain.usecase

import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.data.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {
    fun getRestaurantSearch(query: String): Flow<Resource<List<Restaurant>>>
}