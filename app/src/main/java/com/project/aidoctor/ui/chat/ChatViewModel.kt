package com.project.aidoctor.ui.chat





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.data.repository.chat.ChatRepository

class ChatViewModel(private val repository: ChatRepository): ViewModel(){

    var chatListener:ChatListener? = null




}