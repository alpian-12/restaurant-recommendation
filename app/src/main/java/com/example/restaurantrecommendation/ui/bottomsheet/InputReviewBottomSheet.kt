package com.example.restaurantrecommendation.ui.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.restaurantrecommendation.databinding.BottomSheetInputReviewBinding
import com.example.restaurantrecommendation.ui.detailrestaurant.reviewdetailrestaurant.ReviewDetailRestaurantFragment

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InputReviewBottomSheet : BottomSheetDialogFragment(){

    private var _binding: BottomSheetInputReviewBinding? = null
    private val binding get() = _binding!!



    companion object {
        const val TAG = "InputReviewBottomSheet"
        const val RATING = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetInputReviewBinding.inflate(inflater, container, false)
        val mArgs = arguments
        val myValue = mArgs!!.getString("key")
        Log.e(TAG, "onCreateView: ${myValue.toString()}", )
        binding.ratingBar.rating = myValue?.toFloat() ?: 0.0f
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = Bundle()
        args.putString("key"," rating.toString()")
        val reviewDetailRestaurantFragment = ReviewDetailRestaurantFragment()
        reviewDetailRestaurantFragment.arguments = args

    }

}