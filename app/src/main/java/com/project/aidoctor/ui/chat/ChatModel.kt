package com.project.aidoctor.ui.chat

import android.graphics.Bitmap
import com.project.aidoctor.data.remote.chat.ChatButton
import com.project.aidoctor.data.remote.chat.ChatSendResults
import com.project.aidoctor.data.remote.chat.ChatStartResponse

class ChatModel(val isMe:Boolean = false, val thumbnail:String="", val text:String? = "",val listItem: ArrayList<ChatButton>?=null) {

}