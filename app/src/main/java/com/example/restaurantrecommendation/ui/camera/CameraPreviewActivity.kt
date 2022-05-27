package com.example.restaurantrecommendation.ui.camera

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantrecommendation.databinding.ActivityCameraPreviewBinding
import com.example.restaurantrecommendation.util.rotateBitmap
import java.io.File

class CameraPreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myFile = intent.getSerializableExtra("picture") as File
        val isBackCamera = intent.getBooleanExtra("isBackCamera", true)

        val result = rotateBitmap(
            BitmapFactory.decodeFile(myFile.path),
            true
        )

        binding.ivFood.setImageBitmap(result)


    }
}