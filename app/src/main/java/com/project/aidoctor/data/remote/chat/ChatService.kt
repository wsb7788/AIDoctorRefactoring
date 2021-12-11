package com.project.aidoctor.data.remote.chat

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface ChatService {
    @GET("/api/chatStart2")
    suspend fun chatStart(
    ): Response<ChatStartResponse>

    @FormUrlEncoded
    @POST("/api/chatSend2")
    suspend fun chatSend(
        @Field("message") message:String,
        @Field("cvsID") cvsID:String,
    ): Response<ChatSendResponse>
}