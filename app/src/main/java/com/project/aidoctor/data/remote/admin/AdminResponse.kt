package com.project.aidoctor.data.remote.admin

import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital
import com.project.aidoctor.data.remote.chat.ChatStartResults
import java.io.Serializable


data class EmListResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: asd
)
data class asd(
    val results: ArrayList<EmUser>
)
data class EmUser(
    val USER_ID: Int,
    val USER_USERID: String
):Serializable