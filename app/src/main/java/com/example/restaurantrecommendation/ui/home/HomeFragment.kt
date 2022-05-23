package com.example.restaurantrecommendation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.adapter.RestaurantAdapter
import com.example.restaurantrecommendation.databinding.FragmentHomeBinding
import com.example.restaurantrecommendation.model.Restaurant
import com.example.restaurantrecommendation.ui.home.category.CategoryBottomSheet
import com.example.restaurantrecommendation.ui.home.location.LocationBottomSheet
import com.example.restaurantrecommendation.ui.category.CategoryActivity
import com.example.restaurantrecommendation.ui.profile.ProfileActivity
import com.example.restaurantrecommendation.ui.result.ResultActivity

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListener()

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

    private fun setOnClickListener() {
        with(binding) {
            tvYourLocation.setOnClickListener(this@HomeFragment)
            tvInput.setOnClickListener(this@HomeFragment)
            btnMore.setOnClickListener(this@HomeFragment)
            btnSweets.setOnClickListener(this@HomeFragment)
            btnRice.setOnClickListener(this@HomeFragment)
            btnMeatball.setOnClickListener(this@HomeFragment)
            btnChicken.setOnClickListener(this@HomeFragment)
            btnDrinks.setOnClickListener(this@HomeFragment)
            btnCoffee.setOnClickListener(this@HomeFragment)
            btnSeafood.setOnClickListener(this@HomeFragment)
            ivProfile.setOnClickListener(this@HomeFragment)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_your_location -> {
                val locationBottomSheet = LocationBottomSheet()
                locationBottomSheet.show(parentFragmentManager, LocationBottomSheet.TAG)
            }
            R.id.tv_input -> {
                startActivity(Intent(activity, ResultActivity::class.java))
            }
            R.id.btn_more -> {
                val categoryBottomSheet = CategoryBottomSheet()
                categoryBottomSheet.show(parentFragmentManager, CategoryBottomSheet.TAG)
            }
            R.id.btn_sweets -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.sweets))
                )
            }
            R.id.btn_rice -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.rice))
                )
            }
            R.id.btn_meatball -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.meatball))
                )
            }
            R.id.btn_chicken -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.chicken))
                )
            }
            R.id.btn_drinks -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.drinks))
                )
            }
            R.id.btn_coffee -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.coffee))
                )
            }
            R.id.btn_seafood -> {
                startActivity(
                    Intent(activity, CategoryActivity::class.java)
                        .putExtra(CategoryActivity.CATEGORY_NAME, resources.getString(R.string.seafood))
                )
            }
            R.id.iv_profile -> {
                startActivity(Intent(activity, ProfileActivity::class.java))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}