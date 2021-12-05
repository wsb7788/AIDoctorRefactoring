package com.project.aidoctor.data.remote.login

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface LoginService {
    @POST("/auth/login/")
    suspend fun login(
        @Body user: User
    ): Response<LoginResponse>

}