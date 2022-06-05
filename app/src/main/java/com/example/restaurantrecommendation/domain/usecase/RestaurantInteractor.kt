package com.example.restaurantrecommendation.domain.usecase

import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.domain.repository.IRestaurantRepository
import kotlinx.coroutines.flow.Flow

class RestaurantInteractor(private val iRestaurantRepository: IRestaurantRepository): RestaurantUseCase {
    override fun searchRestaurant(
        search: String, lat: Double, long: Double
    ) = iRestaurantRepository.searchRestaurant(search, lat, long)
}