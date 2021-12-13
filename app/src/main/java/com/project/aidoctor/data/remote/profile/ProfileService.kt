package com.project.aidoctor.data.remote.profile

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.login.SetTokenResponse

import retrofit2.Response
import retrofit2.http.*

interface ProfileService {
    @GET("/auth/logout/")
    suspend fun logout(
    ): Response<LogoutResponse>

    @FormUrlEncoded
    @POST("/fcm/deleteToken/")
    suspend fun deleteToken(
        @Field("userId") userId: Int
    ): Response<DeleteTokenResponse>

}