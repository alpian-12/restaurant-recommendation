package com.example.restaurantrecommendation.data.source.remote

import com.example.restaurantrecommendation.data.source.remote.network.ApiService

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    // get data di sini

}