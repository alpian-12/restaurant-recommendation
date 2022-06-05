package com.example.restaurantrecommendation.ui.result

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.data.source.remote.network.ApiConfig
import com.example.restaurantrecommendation.data.source.remote.response.ListRestaurantSearchResponse
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.domain.usecase.RestaurantUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultViewModel(restaurantUseCase: RestaurantUseCase): ViewModel() {
//    private val _restaurants = MutableLiveData<List<RestaurantSearchResponse>>()
//    val restaurants : LiveData<List<RestaurantSearchResponse>> get() = _restaurants
//
//    fun getRestaurant(search: String, lat: Float, long: Float) {
//        ApiConfig.provideApiService()
//            .getRestaurantSearch(search, lat, long)
//            .enqueue(object: Callback<ListRestaurantSearchResponse> {
//                override fun onResponse(
//                    call: Call<ListRestaurantSearchResponse>,
//                    response: Response<ListRestaurantSearchResponse>
//                ) {
//                    if(response.isSuccessful) {
//                        _restaurants.postValue(response.body()?.results)
//                    }
//                }
//
//                override fun onFailure(call: Call<ListRestaurantSearchResponse>, t: Throwable) {
//                    t.message?.let { Log.d("Failure", it) }
//                }
//
//            })
//    }

    private lateinit var search: String
    private lateinit var location: Location

    val restaurant = restaurantUseCase.searchRestaurant(search, location.latitude, location.longitude).asLiveData()
}