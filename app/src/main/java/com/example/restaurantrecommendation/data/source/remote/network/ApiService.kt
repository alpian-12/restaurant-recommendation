package com.example.restaurantrecommendation.data.source.remote.network

import com.example.restaurantrecommendation.data.source.remote.response.ListRestaurantSearchResponse
import retrofit2.http.*

interface ApiService {
    @GET("main/nearby")
    suspend fun searchRestaurant(
        @Query("search") search: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double
    ): ListRestaurantSearchResponse

    @GET("main/{id}")
    fun getDetailRestaurant(
        @Path("id") id: String
    ): ListRestaurantSearchResponse

    @POST("users/favorites")
    fun setFavoriteRestaurant(
        @Body user_id: String,
        @Body restaurant_id: String
    )

    @GET("users/favorites")
    suspend fun getFavoriteRestaurant(
        @Query("id") id: String
    )

    @DELETE("users/favorites")
    fun deleteFavoriteRestaurant(
        @Body id: String
    )

}