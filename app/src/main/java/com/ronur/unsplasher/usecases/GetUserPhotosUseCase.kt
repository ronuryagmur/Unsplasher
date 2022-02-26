package com.ronur.unsplasher.usecases

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.ronur.unsplasher.base.BaseUseCase
import com.ronur.unsplasher.data.Photo
import com.ronur.unsplasher.repository.Repository
import com.ronur.unsplasher.utils.response.ApiResponse
import javax.inject.Inject

class GetUserPhotosUseCase @Inject constructor(private val repository: Repository): BaseUseCase<JsonElement, Array<Photo>>() {
    private var username = ""

    fun setUsername(username: String) {
        this.username = username
    }

    override suspend fun getApiCall(): ApiResponse<JsonElement> {
        return repository.getUserPhotos(username)
    }

    override fun jsonToObject(jsonElement: JsonElement): Array<Photo> {
        return Gson().fromJson(jsonElement.toString(), Array<Photo>::class.java)
    }
}