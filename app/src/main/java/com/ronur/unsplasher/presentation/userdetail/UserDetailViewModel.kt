package com.ronur.unsplasher.presentation.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronur.unsplasher.data.Photo
import com.ronur.unsplasher.data.User
import com.ronur.unsplasher.usecases.GetUserPhotosUseCase
import com.ronur.unsplasher.usecases.GetUserUseCase
import com.ronur.unsplasher.utils.onErrorState
import com.ronur.unsplasher.utils.onSuccessState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getUserPhotosUseCase: GetUserPhotosUseCase
) :
    ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _photoList = MutableLiveData<List<Photo>>()
    val photoList = _photoList

    fun fetchUser(username: String) {
        viewModelScope.launch {
            getUserUseCase.setUsername(username)
            getUserUseCase().collect {
                it.onSuccessState {
                    onUserResponseLoaded(data)
                }.onErrorState {
                    Timber.e("userDetailError: $message")
                }
            }
        }
    }

    fun fetchUserPhotos(username: String) {
        viewModelScope.launch {
            getUserPhotosUseCase.setUsername(username)
            getUserPhotosUseCase().collect {
                it.onSuccessState {
                    onUserPhotosLoaded(data)
                }.onErrorState {

                }
            }
        }
    }

    private fun onUserResponseLoaded(user: User) {
        _user.value = user
    }

    private fun onUserPhotosLoaded(photoList: Array<Photo>){
        _photoList.value = photoList.toList()
    }
}