package com.example.restaurantrecommendation.ui.result

import android.Manifest
import android.content.Intent
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.databinding.ActivityResultBinding
import com.example.restaurantrecommendation.ui.camera.CameraActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.example.restaurantrecommendation.util.ViewModelFactory
import com.example.restaurantrecommendation.util.checkPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this@ResultActivity)
        viewModel = ViewModelProvider(this, factory)[ResultViewModel::class.java]

        setToolbar()

        binding.btnCamera.setOnClickListener {
            startActivity(Intent(this@ResultActivity, CameraActivity::class.java))
        }

        binding.swiperefreshresult.setOnRefreshListener {
            binding.swiperefreshresult.isRefreshing = false
        }

        val foodname = intent?.getStringExtra(FOOD_NAME)
        if (foodname.isNullOrEmpty()){
            binding.search.requestFocus()
        }
        else {
//            binding.search.setText(foodname)

        }

//        setSarch()

//        binding.rvRestaurant.layoutManager = LinearLayoutManager(this)
//
//        resultViewModel.restaurants.observe(this) {
//            val restaurantAdapter = RestaurantAdapter(it)
//            restaurantAdapter.notifyDataSetChanged()
//            binding.rvRestaurant.adapter = restaurantAdapter
//        }
    }

//    private fun setSarch() {
//        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String): Boolean {
//
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                    Log.d("testa", userLocation.toString())
//                    resultViewModel.getRestaurant(newText!!, -6.175392F, 106.827153F)
//                return false
//            }
//
//        })
//    }

    private fun setToolbar() {
        with(binding) {
            search.requestFocus()
            setSupportActionBar(topAppBar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this@ResultActivity,MainActivity::class.java))
        return true
    }

    override fun onBackPressed() {
        startActivity(Intent(this@ResultActivity,MainActivity::class.java))
    }

    companion object {
        const val FOOD_NAME = ""

    }
}