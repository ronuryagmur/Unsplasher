package com.ronur.unsplasher.network

import com.google.gson.JsonElement
import com.ronur.unsplasher.utils.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 20,
        @Query("order_by") order: String = "latest"
    ) : ApiResponse<JsonElement>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ) : ApiResponse<JsonElement>

    @GET("users/{username}/photos")
    suspend fun getUserPhotos(
        @Path("username") username: String,
        @Query("per_page") per_page: Int = 20
    ) : ApiResponse<JsonElement>
}