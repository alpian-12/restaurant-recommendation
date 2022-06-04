package com.example.restaurantrecommendation.data.source.remote

import android.util.Log
import com.example.restaurantrecommendation.data.source.remote.network.ApiResponse
import com.example.restaurantrecommendation.data.source.remote.network.ApiService
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

    // get data dari internet di sini
    suspend fun getRestaurantSearch(query: String): Flow<ApiResponse<List<RestaurantSearchResponse>>> {
        return flow {
            try {
                val response = apiService.getRestaurantSearch()
                if (response.isNotEmpty()){
                    emit(ApiResponse.Success(response))
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