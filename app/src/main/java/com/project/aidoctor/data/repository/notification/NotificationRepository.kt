package com.project.aidoctor.data.repository.notification

import com.project.aidoctor.data.remote.notification.NotificationService
import com.project.aidoctor.data.remote.notification.TraceResponse
import com.project.aidoctor.data.remote.profile.DeleteTokenResponse
import com.project.aidoctor.data.remote.profile.LogoutResponse
import com.project.aidoctor.data.remote.profile.ProfileService
import com.project.aidoctor.data.repository.BaseRepository

class NotificationRepository(private val notificationService: NotificationService) : BaseRepository() {
    suspend fun trace(userId:Int): TraceResponse {
        return apiRequest { notificationService.trace(userId) }
    }

}
