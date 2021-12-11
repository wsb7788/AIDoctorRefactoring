package com.project.aidoctor.data.remote.profile

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface ProfileService {
    @GET("/auth/logout/")
    suspend fun logout(
    ): Response<LogoutResponse>

}