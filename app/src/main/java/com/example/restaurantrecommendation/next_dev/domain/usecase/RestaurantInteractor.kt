package com.example.restaurantrecommendation.next_dev.domain.usecase

import com.example.restaurantrecommendation.next_dev.domain.repository.IRestaurantRepository

class RestaurantInteractor(private val iRestaurantRepository: IRestaurantRepository)
//    : RestaurantUseCase {
//
//    override fun searchRestaurant(search: String, lat: Double, long: Double)
//        = iRestaurantRepository.searchRestaurant(search, lat, long)
//
//    override fun getDetailRestaurant(id: String)
//        = iRestaurantRepository.getDetailRestaurant(id)
//}