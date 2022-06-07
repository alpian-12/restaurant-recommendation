package com.example.restaurantrecommendation.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.remote.response.RestaurantSearchResponse
import com.example.restaurantrecommendation.databinding.ItemRestaurantBinding
import com.example.restaurantrecommendation.model.Restaurant
import com.example.restaurantrecommendation.ui.detailrestaurant.DetailRestaurantActivity
import java.util.ArrayList

class RestaurantAdapterSimple : RecyclerView.Adapter<RestaurantAdapterSimple.MyViewHolder>() {
    private var fav = false

    private var restaurants = ArrayList<RestaurantSearchResponse>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<RestaurantSearchResponse>?) {
        if (newListData == null) return
        restaurants.clear()
        restaurants.addAll(newListData)
        notifyDataSetChanged()
    }


    inner class MyViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: RestaurantSearchResponse) {
            binding.apply {
                with(restaurant) {
                    RestaurantName.text = name
                    AddressRestaurant.text = vicinity
                    rateRestaurant.text = rating.toString()

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailRestaurantActivity::class.java)
                        intent.putExtra(DetailRestaurantActivity.PLACE_ID, place_id)
                        itemView.context.startActivity(intent)
                    }
                }
                buttonFavorite.setOnClickListener {
                    fav = !fav
                    favorite(buttonFavorite)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(restaurants[position])
    }

    override fun getItemCount(): Int = restaurants.size
    private fun favorite(buttonFavorite: ImageButton) {
        if (fav) {
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite_active)
        } else {
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite)
        }
    }
}