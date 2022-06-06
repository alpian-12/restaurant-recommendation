package com.example.restaurantrecommendation.ui.result

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.adapter.RestaurantAdapter
import com.example.restaurantrecommendation.data.Resource
import com.example.restaurantrecommendation.databinding.ActivityResultBinding
import com.example.restaurantrecommendation.ui.bottomsheet.NoLocationBottomSheet
import com.example.restaurantrecommendation.ui.camera.CameraActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.example.restaurantrecommendation.util.*
import com.google.android.gms.location.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityResultBinding
    private lateinit var resultViewModel: ResultViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this@ResultActivity)
        resultViewModel = ViewModelProvider(this, factory)[ResultViewModel::class.java]

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setToolbar()

        setOnClickListener()
        
        getLocation()
        Log.e("disini", resultViewModel.location.toString())


        setFoodLabel()

        showRecyclerView()

    }

    private fun setOnClickListener() {
        with(binding) {
            btnCamera.setOnClickListener(this@ResultActivity)
            swiperefreshresult.setOnRefreshListener{
                binding.swiperefreshresult.isRefreshing = false
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_camera -> {
                startActivity(Intent(this@ResultActivity, CameraActivity::class.java))
            }
        }
    }

    private fun showRecyclerView() {
        val restaurntAdapter = RestaurantAdapter()
        resultViewModel.restaurant.observe(this@ResultActivity) { restaurant ->
            if(restaurant != null) {
                when(restaurant) {
                    is Resource.Success -> {
                        restaurntAdapter.setData(restaurant.data)
                    }
                }
            }
        }

        with(binding.rvRestaurant) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = restaurntAdapter
        }
    }

    private fun setSearch() {
        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun getLocation() {
        if(checkLocationPermission(this@ResultActivity)) {
            if(isLocationEnabled(this@ResultActivity)) {
                fusedLocationClient.lastLocation.addOnCompleteListener(this) {
                    val location: Location? = it.result
                    if (location != null) {
                        Toast.makeText(this, location.latitude.toString(), Toast.LENGTH_SHORT).show()
                        resultViewModel.location = location
                    }
                }
            } else {
                val noLocationBottomSheet = NoLocationBottomSheet()
                noLocationBottomSheet.show(supportFragmentManager, NoLocationBottomSheet.TAG)
            }
        } else {
            requestLocationPermission(this@ResultActivity)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == PERMISSION_REQUEST_ACCESS_LOCATION) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                getLocation()
            } else {
                //denied
            }
        }
    }

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

    private fun setFoodLabel() {
        val foodname = intent?.getStringExtra(FOOD_NAME)
        if (foodname.isNullOrEmpty()){
            binding.search.requestFocus()
        }
        else {
            binding.search.setQuery(foodname, false)
        }
    }
}