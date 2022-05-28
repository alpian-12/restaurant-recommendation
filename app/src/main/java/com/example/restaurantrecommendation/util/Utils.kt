package com.example.restaurantrecommendation.util

import android.app.Application
import android.graphics.Bitmap
import android.graphics.Matrix
import com.example.restaurantrecommendation.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

private const val FILENAME_FORMAT = "dd-MMM-yyyy"

val timeStamp: String = SimpleDateFormat(
    FILENAME_FORMAT,
    Locale.US
).format(System.currentTimeMillis())

fun createFile(application: Application): File {
    val mediaDir = application.externalMediaDirs.firstOrNull()?.let {
        File(it, application.resources.getString(R.string.app_name)).apply { mkdirs() }
    }

    val outputDirectory = if (
        mediaDir != null && mediaDir.exists()
    ) mediaDir else application.filesDir

    return File(outputDirectory, "$timeStamp.jpg")
}

fun rotateBitmap(bitmap: Bitmap): Bitmap {
    val matrix = Matrix()
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width ,bitmap.height, matrix,  true)
}