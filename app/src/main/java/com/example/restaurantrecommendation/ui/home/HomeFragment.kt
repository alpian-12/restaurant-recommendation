package com.example.restaurantrecommendation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantrecommendation.databinding.FragmentHomeBinding
import com.example.restaurantrecommendation.ui.bottomsheet.CategoryBottomSheet
import com.example.restaurantrecommendation.ui.result.ResultActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvInput.setOnClickListener {
            startActivity(Intent(activity, ResultActivity::class.java))
        }

        binding.btnMore.setOnClickListener {
            val categoryBottomSheet = CategoryBottomSheet()
            categoryBottomSheet.show(parentFragmentManager, CategoryBottomSheet.TAG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}