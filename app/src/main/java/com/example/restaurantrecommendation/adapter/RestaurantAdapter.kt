package com.example.restaurantrecommendation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantrecommendation.databinding.ItemRestaurantBinding
import com.example.restaurantrecommendation.model.Restaurant

class RestaurantAdapter(private val restaurants : ArrayList<Restaurant>): RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (restaurant: Restaurant) {
            binding.apply {
                with(restaurant) {
                    RestaurantName.text = name
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantAdapter.MyViewHolder {
        val view = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(restaurants[position])
    }

    override fun getItemCount(): Int = restaurants.size
}