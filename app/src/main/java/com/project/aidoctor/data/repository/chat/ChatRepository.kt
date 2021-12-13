package com.project.aidoctor.data.repository.chat

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.chat.ChatSendResponse
import com.project.aidoctor.data.remote.chat.ChatService
import com.project.aidoctor.data.remote.chat.ChatStartResponse
import com.project.aidoctor.data.remote.chat.EmergencyResponse

import com.project.aidoctor.data.remote.login.LoginResponse
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.repository.BaseRepository

class ChatRepository(private val chatService: ChatService) : BaseRepository() {
    suspend fun chatStart(): ChatStartResponse {
        return apiRequest { chatService.chatStart() }
    }
    suspend fun chatSend(message:String,cvsID:String): ChatSendResponse {
        return apiRequest { chatService.chatSend(message,cvsID) }
    }
    suspend fun emergency(userId:Int): EmergencyResponse {
        return apiRequest { chatService.emergency(userId) }
    }
}
