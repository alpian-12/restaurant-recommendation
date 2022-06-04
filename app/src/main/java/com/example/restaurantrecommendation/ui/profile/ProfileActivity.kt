package com.example.restaurantrecommendation.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.data.source.remote.network.Firebase
import com.example.restaurantrecommendation.databinding.ActivityProfileBinding
import com.example.restaurantrecommendation.databinding.DialogQuitBinding
import com.example.restaurantrecommendation.ui.auth.login.LoginActivity
import com.example.restaurantrecommendation.ui.profile.editprofile.EditProfileActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var bindingDialog: DialogQuitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.menuLogout.setOnClickListener {
            bindingDialog = DialogQuitBinding.inflate(layoutInflater)
            val view = View.inflate(this@ProfileActivity, R.layout.dialog_quit, null)

            val builder = AlertDialog.Builder(this@ProfileActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)

            bindingDialog.btnNegative.setOnClickListener {
                dialog.dismiss()
            }

            bindingDialog.btnPositive.setOnClickListener{
                Firebase.authInstance().signOut()
                startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
                finish()
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