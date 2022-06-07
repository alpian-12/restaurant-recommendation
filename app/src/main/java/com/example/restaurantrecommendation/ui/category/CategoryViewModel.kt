package com.example.restaurantrecommendation.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantrecommendation.remote.network.ApiConfig
import com.example.restaurantrecommendation.remote.response.ListRestaurantSearchResponse
import com.example.restaurantrecommendation.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.next_dev.domain.usecase.RestaurantUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class CategoryViewModel(restaurantUseCase: RestaurantUseCase) : ViewModel() {
class CategoryViewModel: ViewModel() {
    private val _listRestaurant = MutableLiveData<List<RestaurantSearchResponse>>()
    val listRestaurant: LiveData<List<RestaurantSearchResponse>> = _listRestaurant
    var search: String = ""
    var lat: Double = 0.0
    var long: Double = 0.0


    fun SetSearchRestaurant(search: String, lat: Double, long: Double) {
        val client = ApiConfig.provideApiService().simpleSearchRestaurant(search, lat, long)
        client.enqueue(object : Callback<ListRestaurantSearchResponse> {
            override fun onResponse(
                call: Call<ListRestaurantSearchResponse>,
                response: Response<ListRestaurantSearchResponse>
            ) {
                if (response.isSuccessful) {
                    _listRestaurant.value = response.body()?.results
                }
                else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ListRestaurantSearchResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun GetSearchRestaurant(): LiveData<List<RestaurantSearchResponse>> {
        return listRestaurant
    }
    companion object{
        private const val TAG = "MainViewModel"
    }
}