package com.example.restaurantrecommendation.model


data class RestaurantDetail(
    val place_id: String,
    var name: String,
//    val address: String,
//    var lat: Double,
//    var long: Double,
//    var rating: Double,
//    val price_level: Int,
    var isFavorite: Boolean = false,
)