package com.ronur.unsplasher.presentation.photodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.ronur.unsplasher.databinding.FragmentPhotoDetailBinding
import com.ronur.unsplasher.base.BaseFragment

class PhotoDetailFragment : BaseFragment<FragmentPhotoDetailBinding>(false) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPhotoDetailBinding
        get() = FragmentPhotoDetailBinding::inflate

    private val args: PhotoDetailFragmentArgs by navArgs()

    override fun bindData() {
        binding.photo = args.photo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.llUserContainer.setOnClickListener {
            val action = PhotoDetailFragmentDirections.photoDetailToUserDetail(args.photo.user.username)
            findNavController().navigate(action)
        }
    }

}