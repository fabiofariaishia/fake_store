package com.walker.fakeecommerce.network

import com.walker.fakeecommerce.model.AcessToken
import com.walker.fakeecommerce.model.LoginUser
import com.walker.fakeecommerce.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("users")
    suspend fun postUser(
        @Body user: User
    ): Response<User>

    @POST("auth/login")
    suspend fun postLogin(
        @Body loginUser: LoginUser
    ): Response<AcessToken>
}