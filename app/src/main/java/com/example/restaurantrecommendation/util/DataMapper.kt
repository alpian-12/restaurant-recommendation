package com.example.restaurantrecommendation.util

import com.example.restaurantrecommendation.data.source.local.entity.RestaurantEntity
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.domain.model.Restaurant

object DataMapper {
    fun mapResponsesToEntities(input: List<RestaurantSearchResponse>): List<RestaurantEntity> {
        val tourismList = ArrayList<RestaurantEntity>()
        input.map {
            val tourism = RestaurantEntity(
                place_id = it.place_id,
                name = it.name,
//                lat = it.geometry.location.lat,
//                long = it.geometry.location.lng,
//                address = it.vicinity,
//                rating = it.rating,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<RestaurantEntity>): List<Restaurant> =
        input.map {
            Restaurant(
                place_id = it.place_id,
                name = it.name,
//                lat = it.lat,
//                long = it.long,
//                address =it.address,
//                rating = it.rating,
                isFavorite = it.isFavorite
            )
        }

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