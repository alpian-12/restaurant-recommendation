package com.example.restaurantrecommendation.remote.network

import com.example.restaurantrecommendation.remote.response.ListRestaurantDetailResponse
import com.example.restaurantrecommendation.remote.response.ListRestaurantSearchResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("main/nearby")
    suspend fun searchRestaurant(
        @Query("search") search: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double
    ): ListRestaurantSearchResponse

    @GET("main/nearby")
    fun simpleSearchRestaurant(
        @Query("search") search: String,
        @Query("lat") lat: Double,
        @Query("long") long: Double
    ): Call<ListRestaurantSearchResponse>


    @GET("main/details/{id}")
    fun getDetailRestaurant(
        @Path("id") id: String
    ): ListRestaurantDetailResponse

    @GET("main/details/{id}")
    fun simpleDetailRestaurant(
        @Path("id") id: String
    ): Call<ListRestaurantDetailResponse>

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