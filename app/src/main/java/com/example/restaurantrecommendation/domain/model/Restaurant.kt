package com.example.restaurantrecommendation.domain.model

import com.example.restaurantrecommendation.data.source.remote.response.*

data class Restaurant(
    val place_id: String,
    val name: String,
    val isFavorite: Boolean = false

//    val address_components: List<ListAddressComponentsResponse>,
//    val formatted_address: String,
//    val formatted_phone_number: String,
//    val geometry: ListGeometryResponse,
//    val name: String,
//    val opening_hours: ListOpeningHoursReponse,
//    val photos: List<ListPhotosResponse>,
//    val place_id: String,
//    val rating: Float,
)
