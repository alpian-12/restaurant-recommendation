package com.example.restaurantrecommendation.data.source.local

import com.example.restaurantrecommendation.data.source.local.entity.RestaurantEntity
import com.example.restaurantrecommendation.data.source.local.room.RestaurantDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val restaurantDao: RestaurantDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(restaurantDao: RestaurantDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(restaurantDao)
            }
    }

    fun searchRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.searchRestaurant()

    suspend fun insertRestaurant(restaurantList: List<RestaurantEntity>) = restaurantDao.insertRestaurant(restaurantList)
}