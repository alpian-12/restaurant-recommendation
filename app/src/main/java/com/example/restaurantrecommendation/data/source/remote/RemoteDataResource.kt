package com.example.restaurantrecommendation.data.source.remote

import android.util.Log
import com.example.restaurantrecommendation.data.source.remote.network.ApiResponse
import com.example.restaurantrecommendation.data.source.remote.network.ApiService
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantDetailResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    suspend fun searchRestaurant(search: String, lat: Double, long: Double): Flow<ApiResponse<List<RestaurantSearchResponse>>> {
        return flow {
            try {
                val response = apiService.searchRestaurant(search, lat, long)
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailRestaurant(id: String): Flow<ApiResponse<RestaurantDetailResponse>> {
        return flow {
            try {
                val response = apiService.getDetailRestaurant(id)
                val data = response.results
                if (data != null){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}