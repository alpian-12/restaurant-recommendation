package com.example.restaurantrecommendation.ui.detailrestaurant.reviewdetailrestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.R
import com.example.restaurantrecommendation.databinding.FragmentReviewDetailRestaurantBinding
import com.example.restaurantrecommendation.ui.bottomsheet.InputReviewBottomSheet


class ReviewDetailRestaurantFragment : Fragment(), View.OnClickListener {
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

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        with(binding) {
            linearlayoutrate.setOnClickListener(this@ReviewDetailRestaurantFragment)

        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.linearlayoutrate -> {
                val inputReviewBottomSheet = InputReviewBottomSheet()
                inputReviewBottomSheet.show(parentFragmentManager, InputReviewBottomSheet.TAG)
            }
        }
    }

    companion object {

    }
}