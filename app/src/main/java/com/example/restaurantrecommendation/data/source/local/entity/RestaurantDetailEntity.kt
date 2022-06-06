package com.example.restaurantrecommendation.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_detail")
data class RestaurantDetailEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "place_id")
    val place_id: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "lat")
    var lat: Double,

    @ColumnInfo(name = "long")
    var long: Double,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "price_level")
    val price_level: Int,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false,
)