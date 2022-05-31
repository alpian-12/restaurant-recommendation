package com.example.restaurantrecommendation.ui.profile

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.databinding.ActivityProfileBinding
import com.example.restaurantrecommendation.databinding.DialogQuitBinding
import com.example.restaurantrecommendation.ui.profile.editprofile.EditProfileActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var binding_dialog: DialogQuitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.menuLogout.setOnClickListener {

//            val view = View.inflate(this@ProfileActivity, R.layout.dialog_quit, null)
//            binding_dialog = DialogQuitBinding.inflate(layoutInflater)
//            setContentView(binding.root)
//            val view = View.inflate(this@ProfileActivity, R.layout.dialog_quit, null)
//
//            val builder = AlertDialog.Builder(this@ProfileActivity)
//            builder.setView(view)
//
//            val dialog = builder.create()
//            dialog.show()
//            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//            dialog.setCancelable(false)
//            binding_dialog = DialogQuitBinding.inflate(layoutInflater)
//            setContentView(binding_dialog.root)
//            val dialog =Dialog(this)
//            dialog.setCancelable(false)
//            dialog.setContentView(binding_dialog.root)
//            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            binding_dialog = DialogQuitBinding.inflate(layoutInflater)
//            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_quit, null)
            val view = View.inflate(this@ProfileActivity, R.layout.dialog_quit, null)

            val builder = AlertDialog.Builder(this@ProfileActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)
            val cencel = view.findViewById<Button>(R.id.Cencel)
            cencel.setOnClickListener {
                dialog.dismiss()
            }

        }

        binding.menuEditProfile.setOnClickListener {
            startActivity(Intent(this@ProfileActivity,EditProfileActivity::class.java))
        }
        setToolbar()
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
}