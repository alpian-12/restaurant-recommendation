package com.example.restaurantrecommendation.data.source.remote.network

import com.example.restaurantrecommendation.data.source.remote.response.ListRestaurantSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("main/nearby")
    suspend fun searchRestaurant(
        @Query("search") search: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double
    ): ListRestaurantSearchResponse
}