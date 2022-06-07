package com.example.restaurantrecommendation.next_dev.data

import com.example.restaurantrecommendation.next_dev.data.source.local.LocalDataSource
import com.example.restaurantrecommendation.remote.RemoteDataSource

class RestaurantRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
)
//    : IRestaurantRepository {
//
//    companion object {
//        @Volatile
//        private var instance: RestaurantRepository? = null
//
//        fun getInstance(
//            remoteData: RemoteDataSource,
//            localData: LocalDataSource
//        ): RestaurantRepository =
//            instance ?: synchronized(this) {
//                instance ?: RestaurantRepository(remoteData, localData)
//            }
//    }
//
//    override fun searchRestaurant(search: String, lat: Double, long: Double): Flow<Resource<List<Restaurant>>> =
//        object : NetworkBoundResource<List<Restaurant>, List<RestaurantSearchResponse>>() {
//            override fun loadFromDB(): Flow<List<Restaurant>> {
//                return localDataSource.searchRestaurant().map {
//                    RestaurantDataMapper.mapEntitiesToDomain(it)
//                }
//            }
//
//            override fun shouldFetch(data: List<Restaurant>?): Boolean =
////                data == null || data.isEmpty()
//                true // ganti dengan true jika ingin selalu mengambil data dari internet
//
//            override suspend fun createCall(): Flow<ApiResponse<List<RestaurantSearchResponse>>> =
//                remoteDataSource.searchRestaurant(search, lat, long)
//
//            override suspend fun saveCallResult(data: List<RestaurantSearchResponse>) {
//                val restaurantList = RestaurantDataMapper.mapResponsesToEntities(data)
//                localDataSource.insertRestaurant(restaurantList)
//            }
//        }.asFlow()
//
//    override fun getDetailRestaurant(id: String): Flow<Resource<RestaurantDetail>> =
//        object: NetworkBoundResource<RestaurantDetail, RestaurantDetailResponse>() {
//            override fun loadFromDB(): Flow<RestaurantDetail> {
//                return localDataSource.getDetailRestaurant().map {
//                    RestaurantDetailDataMapper.mapEntitiesToDomain(it)
//                }
//            }
//
//            override fun shouldFetch(data: RestaurantDetail?): Boolean =
//                true
//
//            override suspend fun createCall(): Flow<ApiResponse<RestaurantDetailResponse>> =
//                remoteDataSource.getDetailRestaurant(id)
//
//            override suspend fun saveCallResult(data: RestaurantDetailResponse) {
//                val restaurant = RestaurantDetailDataMapper.mapResponsesToEntities(data)
//                localDataSource.insertDetailRestaurant(restaurant)
//            }
//        }.asFlow()
//}