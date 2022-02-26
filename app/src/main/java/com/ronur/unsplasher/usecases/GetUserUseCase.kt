package com.ronur.unsplasher.usecases

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.ronur.unsplasher.base.BaseUseCase
import com.ronur.unsplasher.data.User
import com.ronur.unsplasher.repository.Repository
import com.ronur.unsplasher.utils.response.ApiResponse
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: Repository): BaseUseCase<JsonElement, User>() {
    private var username = ""

    fun setUsername(username: String) {
        this.username = username
    }

    override suspend fun getApiCall(): ApiResponse<JsonElement> {
        return repository.getUser(username)
    }

    override fun jsonToObject(jsonElement: JsonElement): User {
        return Gson().fromJson(jsonElement.toString(), User::class.java)
    }
}