package com.example.restaurantrecommendation.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.di.Injection
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase
import com.example.restaurantrecommendation.ui.category.CategoryViewModel
import com.example.restaurantrecommendation.ui.detailrestaurant.DetailRestaurantViewModel
import com.example.restaurantrecommendation.ui.result.ResultViewModel

class ViewModelFactory private constructor(private val restaurantUseCase: RestaurantUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideRestaurantUseCase(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(ResultViewModel::class.java) -> {
                ResultViewModel(restaurantUseCase) as T
            }
            modelClass.isAssignableFrom(DetailRestaurantViewModel::class.java) -> {
                DetailRestaurantViewModel(restaurantUseCase) as T
            }

            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                CategoryViewModel(restaurantUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}