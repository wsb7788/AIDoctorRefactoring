package com.project.aidoctor.data.remote.admin

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.chat.ChatStartResponse

import retrofit2.Response
import retrofit2.http.*

interface AdminService {
    @GET("/fcm/emList")
    suspend fun emList(
    ): Response<EmListResponse>
}