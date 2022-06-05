package com.example.restaurantrecommendation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.databinding.ItemRestaurantBinding
import com.example.restaurantrecommendation.domain.model.Restaurant
import com.example.restaurantrecommendation.data.source.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.ui.detailrestaurant.DetailRestaurantActivity

class RestaurantAdapter(private val restaurants : List<RestaurantSearchResponse>): RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {
    private var fav = false
    inner class MyViewHolder(private val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (restaurant: RestaurantSearchResponse) {
            binding.apply {
                with(restaurant) {
                    RestaurantName.text = name
                }
                buttonFavorite.setOnClickListener {
                    fav = !fav
                    favorite(buttonFavorite)
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailRestaurantActivity::class.java)
                    itemView.context.startActivity(intent)
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


    private fun favorite(buttonFavorite: ImageButton) {
        if(fav){
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite_active)
        }
        else{
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite)
        }
    }
}