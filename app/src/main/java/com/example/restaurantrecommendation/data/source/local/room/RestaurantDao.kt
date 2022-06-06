package com.example.restaurantrecommendation.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.restaurantrecommendation.data.source.local.entity.RestaurantDetailEntity
import com.example.restaurantrecommendation.data.source.local.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant")
    fun searchRestaurant(): Flow<List<RestaurantEntity>>

    @Query("SELECT * FROM restaurant_detail")
    fun getDetailRestaurant(): Flow<RestaurantDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailRestaurant(restaurant: RestaurantDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: List<RestaurantEntity>)
}