package com.example.restaurantrecommendation.ui.result

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantrecommendation.adapter.RestaurantAdapter
import com.example.restaurantrecommendation.databinding.ActivityResultBinding
import com.example.restaurantrecommendation.data.domain.model.Restaurant
import com.example.restaurantrecommendation.ui.camera.CameraActivity
import com.example.restaurantrecommendation.ui.main.MainActivity
import com.example.restaurantrecommendation.util.rotateBitmap
import java.io.File

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
//        binding.search.requestFocus()

        binding.btnCamera.setOnClickListener {
            launcherIntentCameraX.launch(Intent(this, CameraActivity::class.java))
        }
        binding.swiperefreshresult.setOnRefreshListener {
            binding.swiperefreshresult.isRefreshing = false
        }
        showRecyclerView()
        val foodname = intent?.getStringExtra(FOOD_NAME)
        if (foodname.isNullOrEmpty()){
            binding.search.requestFocus()
        }
        else {
            binding.search.setText(foodname)

        }
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
        startActivity(Intent(this@ResultActivity,MainActivity::class.java))
        return true
    }

    override fun onBackPressed() {
        startActivity(Intent(this@ResultActivity,MainActivity::class.java))
    }
    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CameraActivity.CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
        }
    }

    companion object {
        const val FOOD_NAME = ""

    }
}