package com.example.uilover.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uilover.databinding.FragmentHomeScreenBinding
import com.example.uilover.view.adapter.HomeGridAdapter
import com.example.uilover.viewmodel.HomeScreenViewModel

class HomeScreen : Fragment() {

    companion object {
        fun newInstance() = HomeScreen()
    }

    private val viewModel: HomeScreenViewModel by viewModels()
    private lateinit var binding: FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setData()
        binding.viewmodel = viewModel
        binding.iconsGridLayout.adapter = HomeGridAdapter(requireContext(), viewModel.getDataList())
    }
}