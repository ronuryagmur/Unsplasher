package com.ronur.unsplasher.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronur.unsplasher.data.Photo
import com.ronur.unsplasher.utils.onErrorState
import com.ronur.unsplasher.utils.onSuccessState
import com.ronur.unsplasher.usecases.GetPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPhotoUseCase: GetPhotoUseCase): ViewModel() {
    private val _photoList = MutableLiveData<List<Photo>>()
    val photoList = _photoList

    private fun fetchPhotos(){
        viewModelScope.launch {
            getPhotoUseCase().collect {
                it.onSuccessState {
                    _photoList.value = this.data.toList()
                }.onErrorState {
                    Timber.e("homePhotoError: ${this.message}")
                }
            }
        }
    }

    init {
        fetchPhotos()
    }
}