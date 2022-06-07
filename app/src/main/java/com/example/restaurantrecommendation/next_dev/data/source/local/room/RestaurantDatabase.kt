package com.example.restaurantrecommendation.next_dev.data.source.local.room

import androidx.room.RoomDatabase

abstract class RestaurantDatabase: RoomDatabase() {
//
//    abstract fun restaurantDao(): RestaurantDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: RestaurantDatabase? = null
//
//        fun getInstance(context: Context): RestaurantDatabase =
//            INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    RestaurantDatabase::class.java,
//                    "Resturant.db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//    }
}