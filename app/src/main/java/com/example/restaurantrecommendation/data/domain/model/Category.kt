package com.example.restaurantrecommendation.data.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    var name: String,
    var icon: Int
) : Parcelable
