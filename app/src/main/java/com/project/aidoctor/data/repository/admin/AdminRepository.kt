package com.project.aidoctor.data.repository.admin

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.admin.AdminService
import com.project.aidoctor.data.remote.admin.EmListResponse
import com.project.aidoctor.data.remote.chat.ChatSendResponse
import com.project.aidoctor.data.remote.chat.ChatService
import com.project.aidoctor.data.remote.chat.ChatStartResponse
import com.project.aidoctor.data.remote.chat.EmergencyResponse

import com.project.aidoctor.data.remote.login.LoginResponse
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.repository.BaseRepository

class AdminRepository(private val adminService: AdminService) : BaseRepository() {

    suspend fun emList(): EmListResponse {
        return apiRequest { adminService.emList() }
    }
}
