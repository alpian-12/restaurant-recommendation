package com.example.restaurantrecommendation.ui.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantrecommendation.adapter.RestaurantAdapter
import com.example.restaurantrecommendation.databinding.ActivityResultBinding
import com.example.restaurantrecommendation.model.Restaurant

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        binding.search.requestFocus()

        showRecyclerView()
    }

    private fun showRecyclerView() {
        val list = ArrayList<Restaurant>()

        list.add(Restaurant("Restoran murah"))
        list.add(Restaurant("Restoran mahal"))
        list.add(Restaurant("Restoran murah"))
        list.add(Restaurant("Restoran mahal"))
        list.add(Restaurant("Restoran murah"))
        list.add(Restaurant("Restoran mahal"))
        list.add(Restaurant("Restoran murah"))
        list.add(Restaurant("Restoran mahal"))

        with(binding.rvRestaurant) {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = RestaurantAdapter(list)
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}