package com.ronur.unsplasher.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ronur.unsplasher.databinding.FragmentHomeBinding
import com.ronur.unsplasher.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(true) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val vm: HomeViewModel by viewModels()

    override fun bindData() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.photoAdapter = HomeAdapter()
        binding.vm = vm
    }
}