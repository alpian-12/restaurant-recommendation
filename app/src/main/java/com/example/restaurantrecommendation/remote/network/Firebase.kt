package com.example.restaurantrecommendation.remote.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object Firebase {
    fun currentUser(): FirebaseUser {
        return FirebaseAuth.getInstance().currentUser!!
    }

    fun authInstance() = FirebaseAuth.getInstance()
}