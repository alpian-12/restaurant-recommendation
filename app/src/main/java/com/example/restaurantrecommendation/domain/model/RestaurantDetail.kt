package com.example.restaurantrecommendation.domain.model

import com.example.restaurantrecommendation.data.source.remote.response.*

data class RestaurantDetail(
    val place_id: String,
    val address: String,
    var name: String,
    var lat: Double,
    var long: Double,
    var rating: Double,
    val price_level: Int,
    var isFavorite: Boolean = false,
)