package com.example.restaurantrecommendation.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurantrecommendation.databinding.BottomSheetCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CategoryBottomSheet: BottomSheetDialogFragment() {

    private var _binding: BottomSheetCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "CategoryBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}