package com.ronur.unsplasher.presentation.userdetail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ronur.unsplasher.databinding.FragmentUserDetailBinding
import com.ronur.unsplasher.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<FragmentUserDetailBinding>(false) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserDetailBinding
        get() = FragmentUserDetailBinding::inflate

    private val vm: UserDetailViewModel by viewModels()
    private val args: UserDetailFragmentArgs by navArgs()

    override fun bindData() {
        binding.vm = vm
        binding.adapter = UserDetailPhotoAdapter()
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (vm.user.value == null){
            vm.fetchUser(args.username)
            vm.fetchUserPhotos(args.username)
        }
    }

}