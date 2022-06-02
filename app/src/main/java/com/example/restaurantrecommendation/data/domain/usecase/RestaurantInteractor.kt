package com.example.restaurantrecommendation.data.domain.usecase

import com.example.restaurantrecommendation.data.domain.repository.IRestaurantRepository
import kotlinx.coroutines.flow.Flow

class RestaurantInteractor(private val iRestaurantRepository: IRestaurantRepository): RestaurantUseCase {
    override fun getRestaurantSearch(query: String) = iRestaurantRepository.getRestaurantSearch()
}