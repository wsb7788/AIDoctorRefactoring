package com.project.aidoctor.data.remote.notification

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface NotificationService {
    @FormUrlEncoded
    @POST("/fcm/trace/")
    suspend fun trace(
        @Field("userId") userId: Int
    ): Response<TraceResponse>


}