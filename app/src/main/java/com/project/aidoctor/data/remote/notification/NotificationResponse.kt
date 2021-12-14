package com.project.aidoctor.data.remote.notification

import com.project.aidoctor.data.entities.User


data class TraceResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results:ReRe)


data class ReRe(
    val results:ArrayList<NotiList>)


data class NotiList(
    val FCM_ID:Int,
    val FCM_USER_ID:Int,
    val FCM_CONTENT:String,
    val FCM_DATE:String)



