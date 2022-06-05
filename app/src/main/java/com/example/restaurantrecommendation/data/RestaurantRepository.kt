package com.example.restaurantrecommendation.data

import com.example.restaurantrecommendation.data.source.remote.RemoteDataSource
import com.example.restaurantrecommendation.data.source.remote.network.ApiResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.domain.repository.IRestaurantRepository
import kotlinx.coroutines.flow.Flow

class RestaurantRepository private constructor(
    private val remoteDataSource: RemoteDataSource
) : IRestaurantRepository {

    companion object {
        @Volatile
        private var instance: RestaurantRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource
        ): RestaurantRepository =
            instance ?: synchronized(this) {
                instance ?: RestaurantRepository(remoteData)
            }
    }

    override fun searchRestaurant(
        search: String,
        lat: Double,
        long: Double
    ): Flow<Resource<List<Restaurant>>> =
        object: NetworkBoundResource<List<Restaurant>, List<RestaurantSearchResponse>>() {
//            override fun loadFromDB(): Flow<List<Restaurant>> {
//                return localDataSource.getAllTourism().map {
//                    DataMapper.mapEntitiesToDomain(it)
//                }
//            }

            override fun shouldFetch(data: List<Restaurant>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<RestaurantSearchResponse>>> =
                remoteDataSource.searchRestaurant(search, lat, long)

//            override suspend fun saveCallResult(data: List<RestaurantSearchResponse>) {
//                val tourismList = DataMapper.mapResponsesToEntities(data)
//                localDataSource.insertTourism(tourismList)
//            }
        }.asFlow()
}