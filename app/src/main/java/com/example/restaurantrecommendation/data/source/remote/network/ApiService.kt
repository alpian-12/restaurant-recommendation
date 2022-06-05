package com.example.restaurantrecommendation.data.source.remote.network

import com.example.restaurantrecommendation.data.source.remote.response.ListRestaurantSearchResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("main/nearby")
    fun getRestaurantSearch(
        @Query("search") search: String,
        @Query("lat") lat: Float,
        @Query("long") long: Float
    ): Call<ListRestaurantSearchResponse>

    @GET("main/nearby")
    suspend fun searchRestaurant(
        @Query("search") search: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double
    ): ListRestaurantSearchResponse
}