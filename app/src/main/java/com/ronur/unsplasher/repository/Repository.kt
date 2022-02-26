package com.ronur.unsplasher.repository

import com.google.gson.JsonElement
import com.ronur.unsplasher.network.ApiService
import com.ronur.unsplasher.utils.response.ApiResponse
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPhotos(): ApiResponse<JsonElement> = apiService.getPhotos()

    suspend fun getUser(username: String): ApiResponse<JsonElement> = apiService.getUser(username)

    suspend fun getUserPhotos(username: String): ApiResponse<JsonElement> = apiService.getUserPhotos(username)
}