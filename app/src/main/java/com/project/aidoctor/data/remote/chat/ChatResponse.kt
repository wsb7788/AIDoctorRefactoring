package com.project.aidoctor.data.remote.chat

import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital


data class ChatStartResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: ChatStartResults
)

data class ChatStartResults(
    val thumbnail:String,
    val title: String,
    val listItem:ArrayList<ChatButton>,
    val cvsID: String
)

data class ChatButton(
    val label:String,
    val value: String,
    val required:Boolean
)
/////////////////////////////////////
data class ChatSendResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: ArrayList<ChatSendResults>
)
data class ChatSendResults(
    val type:String,
    val message:ChatSendMessage
)
data class ChatSendMessage(
    val title:String,
    val listItem:ArrayList<ChatButton>
)

data class EmergencyResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String
)