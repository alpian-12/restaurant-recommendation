package com.example.restaurantrecommendation.data.source.remote.network

import com.example.restaurantrecommendation.data.source.remote.response.RestaurantResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("sebuah-nama")
    fun getRestaurantSearch(): List<RestaurantSearchResponse>

    @GET("sebuah-nama")
    fun getRestaurantDetail(): RestaurantResponse
}