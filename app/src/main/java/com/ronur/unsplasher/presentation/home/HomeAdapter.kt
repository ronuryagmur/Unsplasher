package com.ronur.unsplasher.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.ronur.unsplasher.data.Photo
import com.ronur.unsplasher.databinding.ListItemHomePhotoBinding
import com.ronur.unsplasher.base.BaseAdapter

class HomeAdapter : BaseAdapter<ListItemHomePhotoBinding, Photo>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ListItemHomePhotoBinding
        get() = ListItemHomePhotoBinding::inflate
    private val photoList = mutableListOf<Photo>()

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun updateList(list: List<Photo>) {
        photoList.clear()
        photoList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onViewBind(binding: ListItemHomePhotoBinding, position: Int) {
        binding.photo = photoList[position]
        binding.flPhoto.setOnClickListener {
            val action = HomeFragmentDirections.homeToPhotoDetail(photoList[position])
            val extras = FragmentNavigatorExtras(binding.ivPhoto to "shared_element_container")
            it.findNavController().navigate(action,extras)
        }
    }
}