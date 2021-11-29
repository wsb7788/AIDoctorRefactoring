package com.project.aidoctor.data.login

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.login.LoginResponse

import retrofit2.Response
import retrofit2.http.*

interface LoginService {
    @POST("/login/")
    suspend fun login(
        @Body user: User
    ): Response<LoginResponse>

}