package com.project.aidoctor.data.remote.chat_admin

import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital


data class SendFCMResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String
)