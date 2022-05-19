package com.example.restaurantrecommendation.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurantrecommendation.databinding.BottomSheetLocationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LocationBottomSheet: BottomSheetDialogFragment() {
    private var _binding: BottomSheetLocationBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "LocationBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}