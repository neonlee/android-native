package com.example.test.services

import retrofit2.Call
import retrofit2.http.Body
import com.example.test.models.UserModel
import com.example.test.models.UserModelResponse
import retrofit2.http.POST

interface UserService {
    @POST("users")
    fun postUser(@Body userModel: UserModel): Call<UserModelResponse>
}