package com.example.restaurantrecommendation.data

import com.example.restaurantrecommendation.data.domain.model.Restaurant
import com.example.restaurantrecommendation.data.domain.repository.IRestaurantRepository
import com.example.restaurantrecommendation.data.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class RestaurantRepository private constructor(private val remoteDataSource: RemoteDataSource):
    IRestaurantRepository {
    companion object{
        @Volatile
        private var instance: RestaurantRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): RestaurantRepository =
            instance ?: synchronized(this){
                instance ?: RestaurantRepository(remoteDataSource)
            }
    }

    override fun getRestaurantSearch(): Flow<Resource<List<Restaurant>>> {
        TODO("Not yet implemented")
    }
}