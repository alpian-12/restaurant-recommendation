package com.example.restaurantrecommendation.ui.detailrestaurant.reviewdetailrestaurant

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.databinding.FragmentReviewDetailRestaurantBinding
import com.example.restaurantrecommendation.ui.bottomsheet.InputReviewBottomSheet


class ReviewDetailRestaurantFragment : Fragment(),
    RatingBar.OnRatingBarChangeListener {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentReviewDetailRestaurantBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(ReviewRestaurantViewModel::class.java)

        _binding = FragmentReviewDetailRestaurantBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val mArgs = arguments
        val myValue = mArgs?.getString("key")
        Log.e("onCreateView: review", " ${myValue.toString()}")

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnRatingBarChangeListener()
        Log.e("onViewCreated: revieww", "${binding.ratingbarrate.rating}")
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setOnRatingBarChangeListener() {
        with(binding) {
            ratingbarrate.setOnRatingBarChangeListener(this@ReviewDetailRestaurantFragment)
        }


    }


    companion object {

    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        if(rating == 0.0f){
            binding.ratingbarrate.rating = 0.0f
        }
        else{
            val args = Bundle()
            args.putString("key", rating.toString())
            val inputReviewBottomSheet = InputReviewBottomSheet()
            inputReviewBottomSheet.arguments = args
            inputReviewBottomSheet.show(parentFragmentManager, InputReviewBottomSheet.TAG)
            binding.ratingbarrate.rating = 0.0f
        }
    }




}