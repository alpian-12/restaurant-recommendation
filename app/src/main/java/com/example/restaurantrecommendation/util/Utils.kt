package com.example.restaurantrecommendation.util

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.ui.bottomsheet.NoLocationBottomSheet
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

fun checkPermission(permission: Array<String>, context: Context): Boolean {
    return permission.all {
        ContextCompat.checkSelfPermission(
            context,
            it
        ) == PackageManager.PERMISSION_GRANTED
    }
}

fun checkGPS(context: Context, supportFragmentManager: FragmentManager) {
    val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val noLocationBottomSheet = NoLocationBottomSheet()

    if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        noLocationBottomSheet.show(supportFragmentManager, NoLocationBottomSheet.TAG)
    }
}