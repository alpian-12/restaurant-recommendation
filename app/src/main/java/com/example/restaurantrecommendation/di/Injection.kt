package com.example.restaurantrecommendation.di

import android.content.Context
import com.example.restaurantrecommendation.data.RestaurantRepository
import com.example.restaurantrecommendation.data.source.remote.RemoteDataSource
import com.example.restaurantrecommendation.data.source.remote.network.ApiConfig
import com.example.restaurantrecommendation.domain.repository.IRestaurantRepository
import com.example.restaurantrecommendation.domain.usecase.RestaurantInteractor
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase

object Injection {
    private fun provideRepository(context: Context): IRestaurantRepository {
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())

        return RestaurantRepository.getInstance(remoteDataSource)
    }

    fun provideRestaurantUseCase(context: Context): RestaurantUseCase {
        val repository = provideRepository(context)
        return RestaurantInteractor(repository)
    }
}