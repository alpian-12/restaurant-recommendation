package com.example.restaurantrecommendation.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.restaurantrecommendation.databinding.BottomSheetInputReviewBinding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InputReviewBottomSheet : BottomSheetDialogFragment(){

    private var _binding: BottomSheetInputReviewBinding? = null
    private val binding get() = _binding!!



    companion object {
        const val TAG = "InputReviewBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetInputReviewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}