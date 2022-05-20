package com.example.restaurantrecommendation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantrecommendation.databinding.ItemCategoryBinding
import com.example.restaurantrecommendation.model.Category

class CategoryAdapter(private val categories : ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (category : Category) {
            binding.apply {
                with(category) {
                    tvCategory.text = name
                    ivCategory.setImageResource(icon)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.MyViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}