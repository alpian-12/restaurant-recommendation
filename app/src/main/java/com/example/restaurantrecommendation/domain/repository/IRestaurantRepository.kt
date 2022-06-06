package com.example.restaurantrecommendation.domain.repository

import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.domain.model.RestaurantDetail
import kotlinx.coroutines.flow.Flow

interface IRestaurantRepository {
    fun searchRestaurant(search: String, lat: Double, long: Double): Flow<Resource<List<Restaurant>>>
    fun getDetailRestaurant(id: String): Flow<Resource<RestaurantDetail>>
}