package com.project.aidoctor.data.remote.chat

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface ChatService {
    @GET("/api/chatStart")
    suspend fun chatStart(
    ): Response<ChatStartResponse>

    @FormUrlEncoded
    @POST("/api/chatSend")
    suspend fun chatSend(
        @Field("message") message:String
    ): Response<ChatSendResponse>
}