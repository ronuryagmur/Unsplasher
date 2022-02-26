package com.ronur.unsplasher.presentation.userdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ronur.unsplasher.base.BaseAdapter
import com.ronur.unsplasher.data.Photo
import com.ronur.unsplasher.databinding.ListItemUserDetailPhotoBinding

class UserDetailPhotoAdapter : BaseAdapter<ListItemUserDetailPhotoBinding, Photo>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ListItemUserDetailPhotoBinding
        get() = ListItemUserDetailPhotoBinding::inflate

    private val photoList = mutableListOf<Photo>()

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun updateList(list: List<Photo>) {
        photoList.clear()
        photoList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onViewBind(binding: ListItemUserDetailPhotoBinding, position: Int) {
        binding.photo = photoList[position]
        binding.executePendingBindings()
        binding.flUserPhoto.setOnClickListener {
            val action = UserDetailFragmentDirections.userDetailToPhotoDetail(photoList[position])
            it.findNavController().navigate(action)
        }
    }
}