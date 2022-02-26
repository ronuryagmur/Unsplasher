package com.ronur.unsplasher.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(private val persistent: Boolean) : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    internal abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    internal abstract fun bindData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (_binding == null){
            _binding = bindingInflater(inflater, container, false)
            bindData()
        }
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (!persistent)
            _binding = null
    }
}