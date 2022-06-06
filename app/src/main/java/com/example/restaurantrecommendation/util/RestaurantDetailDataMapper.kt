package com.example.restaurantrecommendation.util

import com.example.restaurantrecommendation.data.source.local.entity.RestaurantDetailEntity
import com.example.restaurantrecommendation.data.source.local.entity.RestaurantEntity
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantDetailResponse
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.domain.model.RestaurantDetail

object RestaurantDetailDataMapper {
    fun mapResponsesToEntities(input: RestaurantDetailResponse): RestaurantDetailEntity {
        return RestaurantDetailEntity(
            place_id = input.place_id,
            name = input.name,
//                lat = it.geometry.location.lat,
//                long = it.geometry.location.lng,
//                address = it.vicinity,
//                rating = it.rating,
            isFavorite = false
        )
    }

    fun mapEntitiesToDomain(input: RestaurantDetailEntity): RestaurantDetail =
        RestaurantDetail(
            place_id = input.place_id,
            name = input.name,
//                lat = it.lat,
//                long = it.long,
//                address =it.address,
//                rating = it.rating,
            isFavorite = input.isFavorite
        )

    fun mapDomainToEntity(input: Restaurant) = RestaurantEntity(
        place_id = input.place_id,
        name = input.name,
//        lat = input.lat,
//        long = input.long,
//        address =input.address,
//        rating = input.rating,
        isFavorite = input.isFavorite
    )

}