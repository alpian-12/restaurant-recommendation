package com.example.restaurantrecommendation.data.source.remote.response

data class RestaurantResponse(
    val address_components: Array<ListAddressComponentsResponse>,
    val adr_address: String,
    val business_status: String,
    val formatted_address: String,
    val formatted_phone_number: String,
    val geometry: ListGeometryResponse,
    val icon: String,
    val icon_background_color: String,
    val icon_mask_base_uri: String,
    val international_phone_number: String,
    val name: String,
    val opening_hours: ListOpeningHoursReponse,
    val photos: Array<ListPhotosResponse>,
    val place_id: String,
    val plus_code: ListPlusCodeResponse,
    val price_level: Int,
    val rating: Float,
    val reference: String,
)

data class ListAddressComponentsResponse(
    val long_name: String,
    val short_name: String,
    val types: Array<String>
)
