package com.example.restaurantrecommendation.data.domain.repository

import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.data.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface IRestaurantRepository {
    fun getRestaurantSearch(): Flow<Resource<List<Restaurant>>>
}