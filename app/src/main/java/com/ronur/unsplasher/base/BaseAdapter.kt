package com.ronur.unsplasher.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<VB : ViewBinding, T> :
    RecyclerView.Adapter<BaseAdapter<VB, T>.ViewHolder>() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = bindingInflater(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class ViewHolder(private val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            onViewBind(binding, position)
        }
    }

    internal abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    abstract fun updateList(list: List<T>)
    abstract fun onViewBind(binding: VB, position: Int)
}