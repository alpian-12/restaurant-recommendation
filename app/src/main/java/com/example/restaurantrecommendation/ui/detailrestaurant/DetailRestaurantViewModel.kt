package com.example.restaurantrecommendation.ui.detailrestaurant

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantrecommendation.remote.network.ApiConfig
import com.example.restaurantrecommendation.remote.response.ListRestaurantDetailResponse
import com.example.restaurantrecommendation.remote.response.RestaurantDetailResponse
import com.example.restaurantrecommendation.next_dev.domain.usecase.RestaurantUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRestaurantViewModel(restaurantUseCase: RestaurantUseCase) : ViewModel() {

    private val _restaurant = MutableLiveData<RestaurantDetailResponse>()
    val restaurant : LiveData<RestaurantDetailResponse> = _restaurant

    fun setDetailRestaurant(placeId: String) {
        val client = ApiConfig.provideApiService().simpleDetailRestaurant(placeId)
        client.enqueue(object : Callback<ListRestaurantDetailResponse> {
            override fun onResponse(
                call: Call<ListRestaurantDetailResponse>,
                response: Response<ListRestaurantDetailResponse>
            ) {
                if (response.isSuccessful) {
                    _restaurant.postValue(response.body()?.results)
                }
                else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ListRestaurantDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    companion object{
        private const val TAG = "DetailViewModel"
    }
}