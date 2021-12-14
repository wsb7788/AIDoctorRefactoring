package com.project.aidoctor.data.remote.chat_admin

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface ChatAdminService {
    @FormUrlEncoded
    @POST("/fcm/sendFCM")
    suspend fun sendFCM(
        @Field("userId") userId:Int,
        @Field("message") message:String,

    ): Response<SendFCMResponse>


}