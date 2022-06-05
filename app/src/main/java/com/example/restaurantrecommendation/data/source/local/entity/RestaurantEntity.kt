package com.example.restaurantrecommendation.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class RestaurantEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "place_id")
    var place_id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)