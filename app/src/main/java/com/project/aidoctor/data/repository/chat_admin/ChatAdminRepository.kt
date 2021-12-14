package com.project.aidoctor.data.repository.chat_admin

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.admin.AdminService
import com.project.aidoctor.data.remote.admin.EmListResponse
import com.project.aidoctor.data.remote.chat.ChatSendResponse
import com.project.aidoctor.data.remote.chat.ChatService
import com.project.aidoctor.data.remote.chat.ChatStartResponse
import com.project.aidoctor.data.remote.chat.EmergencyResponse
import com.project.aidoctor.data.remote.chat_admin.ChatAdminService
import com.project.aidoctor.data.remote.chat_admin.SendFCMResponse

import com.project.aidoctor.data.remote.login.LoginResponse
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.repository.BaseRepository

class ChatAdminRepository(private val chatAdminService: ChatAdminService) : BaseRepository() {

    suspend fun sendFCM(userId:Int, message:String): SendFCMResponse {
        return apiRequest { chatAdminService.sendFCM(userId,message) }
    }
}
