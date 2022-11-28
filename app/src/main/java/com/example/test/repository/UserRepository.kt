package com.example.test.repository

import android.util.Log
import com.example.test.models.UserModel
import com.example.test.models.UserModelResponse
import com.example.test.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

object UserRepository {
    private val service: UserService;

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        service = retrofit.create(UserService::class.java)

    }

    fun postUser(userModel: UserModel): UserModelResponse? {
        val call = service.postUser(userModel)
        val execute = call.execute()

        return execute.body()
    }

    fun <UserModel> callback(
        callResponse: (
            response: Response<UserModel>?,
            throwable: Throwable?
        ) -> Unit
    ): Callback<UserModel> {
        return object : Callback<UserModel> {
            override fun onResponse(
                call: Call<UserModel>,
                response: Response<UserModel>
            ) {
                callResponse(response, null)
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                callResponse(null, t)
            }
        }
    }
}