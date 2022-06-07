package com.example.restaurantrecommendation.next_dev.util

import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.next_dev.domain.usecase.RestaurantUseCase

class ViewModelFactory private constructor(private val restaurantUseCase: RestaurantUseCase) :
    ViewModelProvider.NewInstanceFactory() {
//
//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: ViewModelFactory(
//                    Injection.provideRestaurantUseCase(context)
//                )
//            }
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        when {
//            modelClass.isAssignableFrom(ResultViewModel::class.java) -> {
//                ResultViewModel(restaurantUseCase) as T
//            }
//            modelClass.isAssignableFrom(DetailRestaurantViewModel::class.java) -> {
//                DetailRestaurantViewModel(restaurantUseCase) as T
//            }
//
//            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
//                CategoryViewModel(restaurantUseCase) as T
//            }
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }
}