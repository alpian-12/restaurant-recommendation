package com.example.restaurantrecommendation.ui.result

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantrecommendation.adapter.RestaurantAdapter
import com.example.restaurantrecommendation.databinding.ActivityResultBinding
import com.example.restaurantrecommendation.model.Restaurant
import com.example.restaurantrecommendation.ui.camera.CameraActivity
import com.example.restaurantrecommendation.util.rotateBitmap
import java.io.File

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        binding.search.requestFocus()

        binding.btnCamera.setOnClickListener {
            launcherIntentCameraX.launch(Intent(this, CameraActivity::class.java))
        }

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

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CameraActivity.CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            val result = rotateBitmap(
                BitmapFactory.decodeFile(myFile.path),
                isBackCamera
            )
        }
    }
}