package com.example.restaurantrecommendation.next_dev.data.source.local

import com.example.restaurantrecommendation.next_dev.data.source.local.room.RestaurantDao

class LocalDataSource private constructor(private val restaurantDao: RestaurantDao) {

//    companion object {
//        private var instance: LocalDataSource? = null
//
//        fun getInstance(restaurantDao: RestaurantDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(restaurantDao)
//            }
//    }
//
//    fun searchRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.searchRestaurant()
//
//    fun getDetailRestaurant(): Flow<RestaurantDetailEntity> = restaurantDao.getDetailRestaurant()
//
//    suspend fun insertDetailRestaurant(restaurant: RestaurantDetailEntity) = restaurantDao.insertDetailRestaurant(restaurant)
//
//    suspend fun insertRestaurant(restaurantList: List<RestaurantEntity>) = restaurantDao.insertRestaurant(restaurantList)
}